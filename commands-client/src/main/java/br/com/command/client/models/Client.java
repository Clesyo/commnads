package br.com.command.client.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "clients", indexes = { @Index(name = "user_idx_public_id", columnList = "user_public_id") })
public class Client extends BaseEntity {

	private static final long serialVersionUID = 1L;
	private String name;
	private String cpf;
	private String email;
	private String phone;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dateBirth;
	
	@Column(unique = true, name = "user_public_id")
	private String user;

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

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
}
