package br.com.command.client.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.command.client.dtos.RestaurantDto;
import br.com.command.client.forms.RestaurantForm;
import br.com.command.client.interfaces.IRestaurantService;

@RestController
@RequestMapping(path = "/restaurant")
public class RestaurantController {

	@Autowired
	private IRestaurantService restaurantService;

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public RestaurantDto save(@RequestBody RestaurantForm form) {
		return restaurantService.save(form);
	}

	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public RestaurantDto save(@PathVariable Long id, @RequestBody RestaurantForm form) {
		return restaurantService.update(id, form);
	}

}
