package br.com.command.client.dtos;

import java.math.BigDecimal;

import br.com.command.client.models.Product;

public class ProductDto {

	private String name;

	private String description;

	private BigDecimal price;

	private String image;

	private String restaurantPublicId;

	private CategoryDto category;

	public ProductDto(Product product) {
		this.name = product.getName();
		this.description = product.getDescription();
		this.price = product.getPrice();
		this.image = product.getImage();
		this.restaurantPublicId = product.getRestaurant().getPublicId();
		this.category = CategoryDto.convertTo(product.getCategory());
	}

	public static ProductDto convertTo(Product product) {
		return new ProductDto(product);
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

	public String getRestaurantPublicId() {
		return restaurantPublicId;
	}

	public void setRestaurantPublicId(String restaurantPublicId) {
		this.restaurantPublicId = restaurantPublicId;
	}

	public CategoryDto getCategory() {
		return category;
	}

	public void setCategory(CategoryDto category) {
		this.category = category;
	}
}
