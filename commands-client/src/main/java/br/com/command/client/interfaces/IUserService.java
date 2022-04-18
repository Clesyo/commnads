package br.com.command.client.interfaces;

import br.com.command.client.dtos.UserDto;
import br.com.command.client.forms.UserForm;

public interface IUserService {

	UserDto save(UserForm form);
}
