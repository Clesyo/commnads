package br.com.command.client.models;

import java.util.Date;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class Client extends BaseEntity {

	private static final long serialVersionUID = 1L;
	private String name;
	private String cpf;
	private String email;
	private String phone;
	private Date dateBirth;
	
	private User user;

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

	public Date getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(Date dateBirth) {
		this.dateBirth = dateBirth;
	}
}
