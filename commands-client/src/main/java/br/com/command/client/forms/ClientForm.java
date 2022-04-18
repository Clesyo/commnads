package br.com.command.client.forms;

import java.util.Arrays;

import br.com.command.client.models.Client;
import br.com.command.client.utils.Utils;

public class ClientForm {

	private String name;
	private String cpf;
	private String email;
	private String phone;
	private String dateBirth;
	private String password;
	
	public Client toClient(Client...clients) {
		var client = new Client();
		var list = Arrays.asList(clients);
		if(!list.isEmpty())
			client = list.get(0);
		
		client.setCpf(cpf);
		client.setEmail(email);
		client.setName(name);
		client.setPhone(phone);
		client.setDateBirth(Utils.parse(dateBirth));
		return client;
	}
	
	public UserForm toUserForm() {
		return new UserForm(name, email, password);
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
