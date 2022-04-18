package br.com.command.client.services;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.command.client.dtos.RestaurantDto;
import br.com.command.client.forms.RestaurantForm;
import br.com.command.client.interfaces.IRestaurantService;
import br.com.command.client.models.Restaurant;
import br.com.command.client.repository.CityRepository;
import br.com.command.client.repository.RestaurantRepository;
import br.com.command.client.validator.RestaurantValidator;

@Service
public class RestaurantService implements IRestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Autowired
	private RestaurantValidator restaurantValidator;
	
	@Autowired
	private CityRepository cityRepository;

	@Override
	public RestaurantDto save(RestaurantForm form) {
		var restaurant = form.toRestaurant();
		restaurantValidator.validate(form);
		setCityAndState(form.getIbgeCode(), restaurant);
		restaurantRepository.save(restaurant);
		return RestaurantDto.convertTo(restaurant);
	}
	private void setCityAndState(Integer ibgeCode, Restaurant restaurant) {
		var city = cityRepository.findByIbgeCode(ibgeCode).orElseThrow(
				() -> new EntityNotFoundException("Não foi encontrado uma cidade com os dados informados."));
		restaurant.setCity(city);
		restaurant.setState(city.getState());
	}
}
