package br.com.command.client.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.command.client.dtos.UserDto;
import br.com.command.client.feignclient.UserFeignClient;
import br.com.command.client.forms.UserForm;
import br.com.command.client.interfaces.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserFeignClient userFeignClient;

	@Override
	public UserDto save(UserForm form) {
		return userFeignClient.save(form);
	}

}
