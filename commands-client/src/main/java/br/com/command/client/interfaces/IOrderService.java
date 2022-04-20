package br.com.command.client.interfaces;

import br.com.command.client.dtos.OrderDto;
import br.com.command.client.forms.OrderForm;

public interface IOrderService {

	OrderDto save(OrderForm form);
}
