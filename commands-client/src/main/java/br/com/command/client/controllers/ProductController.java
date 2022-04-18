package br.com.command.client.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.command.client.dtos.ProductDto;
import br.com.command.client.forms.ProductForm;
import br.com.command.client.interfaces.IProductService;

@RestController
@RequestMapping(path = "/product")
public class ProductController {

	@Autowired
	private IProductService productService;

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ProductDto save(@RequestBody ProductForm form) {
		return productService.save(form);
	}
}
