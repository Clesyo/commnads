package br.com.command.client.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.command.client.dtos.PaymentDto;
import br.com.command.client.forms.PaymentForm;
import br.com.command.client.interfaces.IPaymentService;

@RestController
@RequestMapping(path = "/payment")
public class PaymentController {

	@Autowired
	private IPaymentService paymentService;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public PaymentDto pay(@RequestBody PaymentForm form) {
		return paymentService.pay(form);
	}
	
}
