package br.com.command.client.services;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.command.client.dtos.OrderDto;
import br.com.command.client.enums.OrderStatus;
import br.com.command.client.forms.OrderForm;
import br.com.command.client.forms.OrderStatusForm;
import br.com.command.client.interfaces.IOrderService;
import br.com.command.client.repository.OrderRepository;
import br.com.command.client.validator.OrderValidator;

@Service
public class OrderService implements IOrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderValidator orderValidator;

	@Override
	public OrderDto save(OrderForm form) {
		var order = form.toOrder();
		orderValidator.validate(form, order);
		orderRepository.save(order);
		return OrderDto.convertTo(order);
	}

	public void changeOrderStatus(String publicId, OrderStatusForm form) {
		orderRepository.findByPublicId(publicId).ifPresentOrElse(order -> {
			order.setStatus(OrderStatus.valueOf(form.getStatus()));
			 orderRepository.save(order);
		}, () -> new EntityNotFoundException("Pedido não encontrado."));
		
	}
}
