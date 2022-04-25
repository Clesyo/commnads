package br.com.command.client.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.command.client.dtos.PaymentDto;
import br.com.command.client.enums.OrderStatus;
import br.com.command.client.forms.PaymentForm;
import br.com.command.client.interfaces.IPaymentService;
import br.com.command.client.models.Payment;
import br.com.command.client.repository.OrderRepository;
import br.com.command.client.repository.PaymentRepository;
import br.com.command.client.validator.PaymentValidator;

@Service
public class PaymentService implements IPaymentService {

	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private PaymentValidator paymentValidator;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public PaymentDto pay(PaymentForm form) {
		Payment pay = form.toPayment();
		paymentValidator.validate(form, pay);
		changeOrderStatus(pay);
		paymentRepository.save(pay);
		return PaymentDto.convertTo(pay);
	}

	private void changeOrderStatus(Payment pay) {
		var order = pay.getOrder();
		order.setStatus(OrderStatus.PAID_OUT);
		orderRepository.save(order);
		pay.setOrder(order);
	}

}
