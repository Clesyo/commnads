package br.com.command.client.forms;

import java.util.List;

import br.com.command.client.enums.OrderStatus;
import br.com.command.client.models.Order;

public class OrderForm {

	private Long restaurantId;

	private Long clientId;

	private List<OrderItemForm> items;

	public Order toOrder() {
		var order = new Order();

		order.setStatus(OrderStatus.CREATED);
		return order;
	}

	public Long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public List<OrderItemForm> getItems() {
		return items;
	}

	public void setItems(List<OrderItemForm> items) {
		this.items = items;
	}
}
