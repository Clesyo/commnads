package br.com.command.serveruser.dto;

import java.util.List;

import br.com.command.serveruser.models.User;

public class UserDto {

	private String publicId;
	private String name;
	private String email;

	private List<String> roles;

	public UserDto(User user) {
		this.publicId = user.getPublicId();
		this.name = user.getName();
		this.email = user.getEmail();
		this.roles = user.getRoles().stream().map(role -> role.getName()).toList();
	}

	public static UserDto convertTo(User user) {
		return new UserDto(user);
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
}
