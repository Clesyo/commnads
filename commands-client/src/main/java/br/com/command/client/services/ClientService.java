package br.com.command.client.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.command.client.dtos.ClientDto;
import br.com.command.client.feignclient.UserFeignClient;
import br.com.command.client.forms.ClientForm;
import br.com.command.client.interfaces.IClientService;
import br.com.command.client.repository.ClientRepository;

@Service
public class ClientService implements IClientService {

	@Autowired
	private UserFeignClient userFeignClient;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Override
	public ClientDto save(ClientForm form) {
		var userForm = form.toUserForm();
		userForm.setRoles(Arrays.asList("CLIENT"));
		var user = userFeignClient.save(userForm);
		var client = form.toClient();
		client.setUser(user.getPublicId());
		clientRepository.save(client);
		return ClientDto.convertTo(client, user);
	}

}
