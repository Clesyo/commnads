package br.com.command.client.dtos;

import br.com.command.client.models.Client;
import br.com.command.client.utils.Utils;

public class ClientDto {

	private String name;
	private String cpf;
	private String email;
	private String phone;
	private String dateBirth;

	private UserDto user;

	public ClientDto(Client client) {
		super();
		this.name = client.getName();
		this.cpf = client.getCpf();
		this.email = client.getEmail();
		this.phone = client.getPhone();
		this.dateBirth = Utils.parse(client.getDateBirth());
	}
	
	public ClientDto(Client client, UserDto user) {
		super();
		this.name = client.getName();
		this.cpf = client.getCpf();
		this.email = client.getEmail();
		this.phone = client.getPhone();
		this.dateBirth = Utils.parse(client.getDateBirth());
		this.user = user;
	}
	
	public static ClientDto convertTo(Client client) {
		return new ClientDto(client);
	}
	
	public static ClientDto convertTo(Client client, UserDto user) {
		return new ClientDto(client, user);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public String getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(String dateBirth) {
		this.dateBirth = dateBirth;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}
}
