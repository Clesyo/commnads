package br.com.command.client.forms;

import java.math.BigDecimal;
import java.util.Arrays;

import br.com.command.client.models.Product;

public class ProductForm {
	
	private String name;

	private String description;

	private BigDecimal price;

	private String image;
	
	private Long restaurantId;
	
	private Long categoryId;

	public Product toProduct(Product...products) {
		var product = new  Product();
		var list = Arrays.asList(products);
		if(!list.isEmpty())
			product = list.get(0);
		
		product.setName(name);
		product.setDescription(description);
		product.setPrice(price);
		product.setImage(image);
		return product;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
}
