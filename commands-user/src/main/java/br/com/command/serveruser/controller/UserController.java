package br.com.command.serveruser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.command.serveruser.dto.UserDto;
import br.com.command.serveruser.form.UserForm;
import br.com.command.serveruser.intefaces.IUserService;

@RestController
@RequestMapping(path = "/user")
public class UserController {

	@Autowired
	private IUserService userService;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public UserDto save(@RequestBody UserForm form) {
		return userService.save(form);
	}
	
	@GetMapping("/{publicId}")
	@ResponseStatus(code = HttpStatus.OK)
	public UserDto findPublicId(@PathVariable String publicId) {
		return userService.findByPublicId(publicId);
	}
}
