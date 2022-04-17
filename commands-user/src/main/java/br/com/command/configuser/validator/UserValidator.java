package br.com.command.configuser.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.command.configuser.exception.InvalidException;
import br.com.command.configuser.form.UserForm;
import br.com.command.configuser.repository.UserRepository;

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
