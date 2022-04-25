package br.com.command.client.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public ProductDto update(@PathVariable Long id, @RequestBody ProductForm form) {
		return productService.update(id, form);
	}

	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public ProductDto findById(@PathVariable Long id) {
		return productService.findById(id);
	}

	@GetMapping()
	@ResponseStatus(code = HttpStatus.OK)
	public Page<ProductDto> findProductFilter(@RequestParam Optional<String> filter,
			@PageableDefault(page = 0, size = 10) Pageable pageable) {
		return productService.findAll(filter, pageable);
	}
}
