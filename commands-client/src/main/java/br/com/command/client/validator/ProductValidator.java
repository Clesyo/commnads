package br.com.command.client.validator;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.command.client.forms.ProductForm;
import br.com.command.client.models.Product;
import br.com.command.client.repository.CategoryRepository;
import br.com.command.client.repository.RestaurantRepository;

@Service
public class ProductValidator {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private RestaurantRepository restaurantRepository;

	public void validate(ProductForm form, Product product) {
		var category = categoryRepository.findById(form.getCategoryId())
				.orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada para ID informado."));
		var restaurant = restaurantRepository.findById(form.getRestaurantId())
				.orElseThrow(() -> new EntityNotFoundException("Restaurante não encontrada para ID informado."));
		
		product.setCategory(category);
		product.setRestaurant(restaurant);
	}
}
