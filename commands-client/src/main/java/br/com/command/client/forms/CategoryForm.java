package br.com.command.client.forms;

import java.util.Arrays;

import br.com.command.client.models.Category;

public class CategoryForm {

	private String name;

	private Long restaurantId;

	public Category toCategory(Category... categories) {
		var category = new Category();
		var list = Arrays.asList(categories);
		if (!list.isEmpty())
			category = list.get(0);
		category.setName(name);
		return category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}
}
