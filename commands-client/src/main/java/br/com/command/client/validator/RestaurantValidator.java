package br.com.command.client.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.command.client.exception.InvalidException;
import br.com.command.client.forms.RestaurantForm;
import br.com.command.client.repository.RestaurantRepository;

@Service
public class RestaurantValidator {

	@Autowired
	private RestaurantRepository restaurantRepository;

	public void validateSave(RestaurantForm form) {
		restaurantRepository.findByCnpj(form.getCnpj()).ifPresent(restaurant -> {
			throw new InvalidException("Já existem um restaurante cadastro com o CNPJ informado.");
		});
	}

	public void validateUpdate(Long id, RestaurantForm form) {
		restaurantRepository.findByCnpjAndIdNot(form.getCnpj(), id).ifPresent(restaurant -> {
			throw new InvalidException(
					"Já existem um restaurante com o mesmo CNPJ, por favor verifique os dados informados.");
		});
	}

}
