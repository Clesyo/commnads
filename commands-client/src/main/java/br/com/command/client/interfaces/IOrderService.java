package br.com.command.client.interfaces;

import br.com.command.client.dtos.OrderDto;
import br.com.command.client.forms.OrderForm;
import br.com.command.client.forms.OrderStatusForm;

public interface IOrderService {

	OrderDto save(OrderForm form);

	void changeOrderStatus(String publicId, OrderStatusForm form);
	
	
}
