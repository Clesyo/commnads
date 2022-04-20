package br.com.command.client.forms;

import br.com.command.client.models.OrderItem;

public class OrderItemForm {

	private Long productId;
	private Integer amount;

	public OrderItem toItem() {
		var item = new OrderItem();

		return item;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

}
