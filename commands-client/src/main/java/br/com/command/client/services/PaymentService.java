package br.com.command.client.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.command.client.dtos.PaymentDto;
import br.com.command.client.forms.PaymentForm;
import br.com.command.client.interfaces.IPaymentService;
import br.com.command.client.models.Payment;
import br.com.command.client.repository.PaymentRepository;
import br.com.command.client.validator.PaymentValidator;

@Service
public class PaymentService implements IPaymentService {

	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private PaymentValidator paymentValidator;

	@Override
	public PaymentDto pay(PaymentForm form) {
		Payment pay = form.toPayment();
		paymentValidator.validate(form, pay);
		paymentRepository.save(pay);
		return PaymentDto.convertTo(pay);
	}

}
