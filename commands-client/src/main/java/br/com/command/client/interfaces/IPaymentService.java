package br.com.command.client.interfaces;

import br.com.command.client.dtos.PaymentDto;
import br.com.command.client.forms.PaymentForm;

public interface IPaymentService {

	PaymentDto pay(PaymentForm form);
}
