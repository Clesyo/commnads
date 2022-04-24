package br.com.command.client.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.command.client.dtos.OrderDto;
import br.com.command.client.forms.OrderForm;
import br.com.command.client.forms.OrderStatusForm;
import br.com.command.client.interfaces.IOrderService;

@RestController
@RequestMapping(path = "/order")
public class OrderController {

	@Autowired
	private IOrderService orderService;

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public OrderDto save(@RequestBody OrderForm form) {
		return orderService.save(form);
	}

	@PatchMapping("/{publicId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void changeOrderStatus(@PathVariable String publicId, @RequestBody OrderStatusForm form) {
		orderService.changeOrderStatus(publicId, form);
	}
}
