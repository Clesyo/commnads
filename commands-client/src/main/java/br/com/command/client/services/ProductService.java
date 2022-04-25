package br.com.command.client.services;

import javax.persistence.EntityNotFoundException;

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

	@Override
	public ProductDto update(Long id, ProductForm form) {
		var product = productRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Produto não encontrado."));
		form.toProduct(product);
		productValidator.validate(form, product);
		productRepository.save(product);
		return ProductDto.convertTo(product);
	}

}
