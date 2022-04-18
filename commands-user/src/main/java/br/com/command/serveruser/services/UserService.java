package br.com.command.serveruser.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.command.serveruser.dto.UserDto;
import br.com.command.serveruser.form.UserForm;
import br.com.command.serveruser.repository.UserRepository;
import br.com.command.serveruser.validator.UserValidator;

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
