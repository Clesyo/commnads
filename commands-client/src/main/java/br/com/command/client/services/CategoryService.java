package br.com.command.client.services;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.command.client.dtos.CategoryDto;
import br.com.command.client.forms.CategoryForm;
import br.com.command.client.interfaces.ICategoryService;
import br.com.command.client.models.Category;
import br.com.command.client.repository.CategoryRepository;
import br.com.command.client.repository.RestaurantRepository;

@Service
public class CategoryService implements ICategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private RestaurantRepository restaurantRepository;

	@Override
	public CategoryDto save(CategoryForm form) {
		var restaurant = restaurantRepository.findById(form.getRestaurantId())
				.orElseThrow(() -> new EntityNotFoundException("Restaurante não encontrado para ID informado."));
		Category category = form.toCategory();
		category.setRestaurant(restaurant);
		categoryRepository.save(category);
		return CategoryDto.convertTo(category);
	}

}
