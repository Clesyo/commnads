package br.com.command.serveruser.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.command.serveruser.exception.InvalidException;
import br.com.command.serveruser.form.UserForm;
import br.com.command.serveruser.repository.UserRepository;

@Service
public class UserValidator {

	@Autowired
	private UserRepository userRepository;

	public void validate(UserForm form) {

		userRepository.findByEmail(form.getEmail())
				.ifPresent(user -> new InvalidException("Já existe um usuário com email cadastrado."));
		;
	}
}
