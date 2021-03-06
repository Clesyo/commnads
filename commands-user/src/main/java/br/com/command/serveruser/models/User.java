package br.com.command.serveruser.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users", indexes = { @Index(name = "user_idx_public_id", columnList = "public_id"), 
		 @Index(name = "user_idx_restaurant_public_id", columnList = "restaurant_public_id")})
public class User extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String name;

	@Column(unique = true)
	private String email;

	private String password;
	
	@Column(name = "restaurant_public_id")
	private String restaurant;

	@ManyToMany
	@JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Role> roles;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
}
