package br.com.command.client.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.command.client.dtos.CategoryDto;
import br.com.command.client.forms.CategoryForm;
import br.com.command.client.interfaces.ICategoryService;
import br.com.command.client.models.Category;
import br.com.command.client.repository.CategoryRepository;

@Service
public class CategoryService implements ICategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public CategoryDto save(CategoryForm form) {
		Category category = form.toCategory();
		categoryRepository.save(category);
		return CategoryDto.convertTo(category);
	}

}
