package br.com.command.client.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import br.com.command.client.utils.Utils;

@Entity
@Table(name = "products", indexes = { @Index(name = "product_idx_public_id", columnList = "public_id") })
public class Product extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String name;

	private String description;

	private BigDecimal price;

	private String image;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	@ManyToOne
	@JoinColumn(name = "restaurant_id")
	private Restaurant restaurant;

	@Column(length = 2048, name = "search_query")
	private String searchQuery;

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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public String getSearchQuery() {
		return searchQuery;
	}

	public void setSearchQuery(String searchQuery) {
		this.searchQuery = searchQuery;
	}

	@PrePersist
	protected void prePersist() {
		super.prePersist();
		concatenateSearchQuery();
	}

	@PreUpdate
	protected void preUpdate() {
		concatenateSearchQuery();
	}

	private void concatenateSearchQuery() {
		String query = "";

		query = this.name != null ? this.name : "";
		query = this.category != null ? this.category.getName() : "";
		this.setSearchQuery(Utils.normalizeToQuery(query));
	}
}
