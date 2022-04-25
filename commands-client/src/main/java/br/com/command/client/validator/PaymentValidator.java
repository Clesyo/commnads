package br.com.command.client.validator;

import java.math.BigDecimal;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.command.client.enums.OrderStatus;
import br.com.command.client.exception.InvalidException;
import br.com.command.client.forms.PaymentForm;
import br.com.command.client.models.Payment;
import br.com.command.client.repository.OrderRepository;

@Service
public class PaymentValidator {

	@Autowired
	private OrderRepository orderRepository;

	private Double sum = 0.00;

	public void validate(PaymentForm form, Payment payment) {
		var order = orderRepository.findByPublicId(form.getOrderPublicId())
				.orElseThrow(() -> new EntityNotFoundException("Pedido inválido."));
		
		if (OrderStatus.SEND_BOX.equals(order.getStatus())) {
			var titles = form.getTitles().stream().map(titleForm -> {
				var title = titleForm.toTitle();
				title.setPayment(payment);
				sum(titleForm.getAmountPaid().doubleValue());
				return title;
			}).toList();

			var subtotal = calculatorSubtotal(form.getDiscount().doubleValue(), order.getTotal().doubleValue());

			if (subtotal > sum || subtotal < sum) {
				throw new InvalidException("Há uma diferença para maior ou menor na somatória dos títulos.");
			}

			if (form.getPaid().doubleValue() < subtotal) {
				throw new InvalidException("Valor pago, é inferior ao total da conta.");
			}

			double troco = form.getPaid().doubleValue() - subtotal;
			payment.setSubTotal(new BigDecimal(subtotal));
			payment.setTotal(order.getTotal());
			payment.setTroco(new BigDecimal(troco));
			payment.setTitles(titles);
			payment.setOrder(order);
			sum = 0.00;
		}else {
			throw new InvalidException("Pedido ainda não foi enviado para caixa.");
		}
	}

	private Double calculatorSubtotal(double discount, double totalOrder) {
		double subtotal = (totalOrder - discount);
		return subtotal;
	}

	private void sum(double value) {
		sum = +value;
	}
}
