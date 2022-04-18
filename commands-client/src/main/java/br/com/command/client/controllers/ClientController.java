package br.com.command.client.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.command.client.dtos.ClientDto;
import br.com.command.client.forms.ClientForm;
import br.com.command.client.interfaces.IClientService;

@RestController
@RequestMapping(path = "/client")
public class ClientController {

	@Autowired
	private IClientService clientService;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ClientDto save(@RequestBody ClientForm form) {
		return clientService.save(form);
	}
}
