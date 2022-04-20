package br.com.command.client.dtos;

import java.util.List;

import br.com.command.client.models.OrderItem;

public class OrderItemDto {

	private Long productId;
	private String product;
	private Integer amount;
	
	public OrderItemDto(OrderItem item) {
		this.productId = item.getProduct().getId();
		this.product = item.getProduct().getName();
		this.amount = item.getAmount();
	}
	
	public static OrderItemDto convertTo(OrderItem item) {
		return new OrderItemDto(item);
	}
	
	public static List<OrderItemDto> convertTo(List<OrderItem> items) {
		return items.stream().map(OrderItemDto::new).toList();
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}
}
