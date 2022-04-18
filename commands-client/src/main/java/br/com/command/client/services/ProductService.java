package br.com.command.client.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.command.client.dtos.ProductDto;
import br.com.command.client.forms.ProductForm;
import br.com.command.client.interfaces.IProductService;
import br.com.command.client.repository.ProductRepository;
import br.com.command.client.validator.ProductValidator;

@Service
public class ProductService implements IProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductValidator productValidator;

	@Override
	public ProductDto save(ProductForm form) {
		var product = form.toProduct();
		productValidator.validate(form, product);
		productRepository.save(product);
		return ProductDto.convertTo(product);
	}

}
