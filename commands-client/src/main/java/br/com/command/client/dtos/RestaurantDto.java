package br.com.command.client.dtos;

import br.com.command.client.models.Restaurant;

public class RestaurantDto {

	private String publicId;

	private String name;

	private String cnpf;

	private String email;

	private String phone;

	private String zipeCode;

	private String street;

	private String complement;

	private Integer number;

	private String distric;

	private String city;
	private String uf;

	public RestaurantDto(Restaurant restaurant) {
		this.publicId = restaurant.getPublicId();
		this.name = restaurant.getName();
		this.cnpf = restaurant.getCnpj();
		this.email = restaurant.getEmail();
		this.phone = restaurant.getPhone();
		this.zipeCode = restaurant.getZipeCode();
		this.street = restaurant.getStreet();
		this.complement = restaurant.getComplement();
		this.number = restaurant.getNumber();
		this.distric = restaurant.getDistric();
		this.city = restaurant.getCity().getName();
		this.uf = restaurant.getCity().getState().getUf();
	}

	public static RestaurantDto convertTo(Restaurant restaurant) {
		return new RestaurantDto(restaurant);
	}

	public String getPublicId() {
		return publicId;
	}

	public void setPublicId(String publicId) {
		this.publicId = publicId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCnpf() {
		return cnpf;
	}

	public void setCnpf(String cnpf) {
		this.cnpf = cnpf;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

}
