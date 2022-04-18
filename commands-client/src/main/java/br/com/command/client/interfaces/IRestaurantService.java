package br.com.command.client.interfaces;

import br.com.command.client.dtos.RestaurantDto;
import br.com.command.client.forms.RestaurantForm;

public interface IRestaurantService {

	RestaurantDto save(RestaurantForm form);
}
