package br.com.command.client.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.command.client.dtos.RestaurantDto;
import br.com.command.client.forms.RestaurantForm;
import br.com.command.client.interfaces.IRestaurantService;
import br.com.command.client.repository.RestaurantRepository;
import br.com.command.client.validator.RestaurantValidator;

@Service
public class RestaurantService implements IRestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepository;
	@Autowired
	private RestaurantValidator restaurantValidator;

	@Override
	public RestaurantDto save(RestaurantForm form) {
		var restaurant = form.toRestaurant();
		restaurantValidator.validate(form);
		restaurantRepository.save(restaurant);
		return RestaurantDto.convertTo(restaurant);
	}

}
