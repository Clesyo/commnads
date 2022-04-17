package br.com.command.configuser.form;

import java.util.Arrays;

import br.com.command.configuser.models.User;

public class UserForm {
	
	private String name;
	private String email;
	private String password;

	public User toUser(User...users) {
		var user = new User();
		var list = Arrays.asList(users);
		if(!list.isEmpty())
			user = list.get(0);
		user.setName(name);
		user.setEmail(email);
		user.setPassword("123456");
		return user;
		
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
}
