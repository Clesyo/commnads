package br.com.command.serveruser.intefaces;

import br.com.command.serveruser.dto.UserDto;
import br.com.command.serveruser.form.UserForm;

public interface IUserService {

	UserDto save(UserForm form);

	UserDto findByPublicId(String publicId);
}
