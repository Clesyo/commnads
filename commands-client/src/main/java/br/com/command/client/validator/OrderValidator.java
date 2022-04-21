package br.com.command.client.validator;

import java.math.BigDecimal;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.command.client.forms.OrderForm;
import br.com.command.client.models.Order;
import br.com.command.client.models.Product;
import br.com.command.client.repository.ClientRepository;
import br.com.command.client.repository.ProductRepository;
import br.com.command.client.repository.RestaurantRepository;

@Service
public class OrderValidator {

	@Autowired
	private RestaurantRepository restaurantRepository;

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private ProductRepository productRepository;

	private Double sum = 0.;

	public void validate(OrderForm form, Order order) {

		var restaurant = restaurantRepository.findById(form.getRestaurantId())
				.orElseThrow(() -> new EntityNotFoundException("Restaurante não encontrado."));

		var client = clientRepository.findById(form.getClientId())
				.orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado."));
		order.setRestaurant(restaurant);
		order.setClient(client);
		validateItems(form, order);
	}

	private void validateItems(OrderForm form, Order order) {
		var items = form.getItems().stream().map(itemForm -> {
			var item = itemForm.toItem();
			var product = validProduct(itemForm.getProductId());
			item.setProduct(product);
			item.setQuantity(itemForm.getQuantity());
			item.setOrder(order);
			sum += itemForm.getQuantity() * product.getPrice().doubleValue();
			return item;
		}).toList();
		BigDecimal total = new BigDecimal(sum);
		order.setItems(items);
		order.setTotal(total);
		total = BigDecimal.ZERO;
	}

	private Product validProduct(Long id) {
		return productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Produto não encontrado."));
	}

}
