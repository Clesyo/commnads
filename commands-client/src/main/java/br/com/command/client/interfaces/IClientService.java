package br.com.command.client.interfaces;

import br.com.command.client.dtos.ClientDto;
import br.com.command.client.forms.ClientForm;

public interface IClientService {

	ClientDto save(ClientForm form);
}
