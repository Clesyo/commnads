package br.com.command.client.interfaces;

import br.com.command.client.dtos.CategoryDto;
import br.com.command.client.forms.CategoryForm;

public interface ICategoryService {

	CategoryDto save(CategoryForm form);
}
