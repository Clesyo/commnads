package br.com.command.client.forms;

import java.util.Arrays;

import br.com.command.client.models.Restaurant;

public class RestaurantForm {

	private String name;

	private String cnpj;

	private String email;

	private String phone;

	private String zipeCode;

	private String street;

	private String complement;

	private Integer number;

	private String distric;
	
	private Integer ibgeCode;

	public Restaurant toRestaurant(Restaurant... restaurants) {
		var restaurant = new Restaurant();
		var list = Arrays.asList(restaurants);
		if (!list.isEmpty())
			restaurant = list.get(0);

		restaurant.setName(name);
		restaurant.setCnpj(getCnpj());
		restaurant.setEmail(email);
		restaurant.setPhone(phone);
		restaurant.setZipeCode(zipeCode);
		restaurant.setStreet(street);
		restaurant.setNumber(number);
		restaurant.setComplement(complement);
		restaurant.setDistric(distric);

		return restaurant;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCnpj() {
		return cnpj.replaceAll("[\\s().-/-]", "");
	}

	public void setCnpj(String cnpf) {
		this.cnpj = cnpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getZipeCode() {
		return zipeCode;
	}

	public void setZipeCode(String zipeCode) {
		this.zipeCode = zipeCode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getDistric() {
		return distric;
	}

	public void setDistric(String distric) {
		this.distric = distric;
	}

	public Integer getIbgeCode() {
		return ibgeCode;
	}

	public void setIbgeCode(Integer ibgeCode) {
		this.ibgeCode = ibgeCode;
	}
}
