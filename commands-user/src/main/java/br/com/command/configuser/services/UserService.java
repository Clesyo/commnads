package br.com.command.configuser.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.command.configuser.dto.UserDto;
import br.com.command.configuser.form.UserForm;
import br.com.command.configuser.repository.UserRepository;
import br.com.command.configuser.validator.UserValidator;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserValidator userValidator;
	
	public UserDto save(UserForm form) {
		var user = form.toUser();
		userValidator.validate(form);
		userRepository.save(user);
		
		return UserDto.convertTo(user);
	}
}
