package br.com.command.client.forms;

import java.util.List;

public class UserForm {

	private String name;
	private String email;
	private String password;

	private List<String> roles;

	public UserForm(ClientForm form) {
		this.name = form.getName();
		this.email = form.getEmail();
		this.password = form.getPassword();
	}
	
	

	

	public UserForm(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}





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

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

}
