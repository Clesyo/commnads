package br.com.command.client.forms;

import br.com.command.client.models.OrderItem;

public class OrderItemForm {

	private Long productId;
	private Integer quantity;

	public OrderItem toItem() {
		var item = new OrderItem();
		item.setQuantity(quantity);
		return item;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer amount) {
		this.quantity = amount;
	}

}
