package br.com.command.client.dtos;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import br.com.command.client.enums.OrderStatus;
import br.com.command.client.models.Order;

public class OrderDto {

	private Long id;
	private ClientDto client;
	private RestaurantDto restaurant;
	private List<OrderItemDto> items;
	private BigDecimal total;
	private OrderStatus status;
	private Date createdAt;
	
	
	public OrderDto(Order order) {
		this.id = order.getId();
		this.client = ClientDto.convertTo(order.getClient());
		this.restaurant = RestaurantDto.convertTo(order.getRestaurant());
		this.items = OrderItemDto.convertTo(order.getItems());
		this.total = order.getTotal();
		this.status = order.getStatus();
		this.createdAt = order.getCreateAt();
	}

	public static OrderDto convertTo(Order order) {
		return new OrderDto(order);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ClientDto getClient() {
		return client;
	}

	public void setClient(ClientDto client) {
		this.client = client;
	}

	public RestaurantDto getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(RestaurantDto restaurant) {
		this.restaurant = restaurant;
	}

	public List<OrderItemDto> getItems() {
		return items;
	}

	public void setItems(List<OrderItemDto> items) {
		this.items = items;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

}
