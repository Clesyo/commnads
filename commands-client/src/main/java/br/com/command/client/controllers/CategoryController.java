package br.com.command.client.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.command.client.dtos.CategoryDto;
import br.com.command.client.forms.CategoryForm;
import br.com.command.client.interfaces.ICategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private ICategoryService categoryService;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public CategoryDto save(@RequestBody CategoryForm form) {
		return categoryService.save(form);
	}
}
