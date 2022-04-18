package br.com.command.client.dtos;

import br.com.command.client.models.Category;

public class CategoryDto {

	private Long id;
	private String name;
	private String restaurantPublicId;

	public CategoryDto(Category category) {
		this.id = category.getId();
		this.name = category.getName();
		this.restaurantPublicId = category.getRestaurant().getPublicId();
	}

	public static CategoryDto convertTo(Category category) {
		return new CategoryDto(category);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRestaurantPublicId() {
		return restaurantPublicId;
	}

	public void setRestaurantPublicId(String restaurantPublicId) {
		this.restaurantPublicId = restaurantPublicId;
	}
}
