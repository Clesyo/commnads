package br.com.command.serveruser.validator;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.command.serveruser.exception.InvalidException;
import br.com.command.serveruser.form.UserForm;
import br.com.command.serveruser.models.User;
import br.com.command.serveruser.repository.RoleRepository;
import br.com.command.serveruser.repository.UserRepository;

@Service
public class UserValidator {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	public void validate(UserForm form, User user) {

		userRepository.findByEmail(form.getEmail())
				.ifPresent(u -> new InvalidException("Já existe um usuário com email cadastrado."));
		var roles = form.getRoles().stream().map(role -> {
			return roleRepository.findByName(role)
					.orElseThrow(() -> new EntityNotFoundException("Função informada não existe."));
		}).toList();
		user.setRoles(roles);
	}
}
