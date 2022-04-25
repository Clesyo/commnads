package br.com.command.client.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.command.client.dtos.ProductDto;
import br.com.command.client.forms.ProductForm;
import br.com.command.client.interfaces.IProductService;
import br.com.command.client.models.Product;
import br.com.command.client.repository.ProductRepository;
import br.com.command.client.utils.Utils;
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
		var product = findId(id);
		form.toProduct(product);
		productValidator.validate(form, product);
		productRepository.save(product);
		return ProductDto.convertTo(product);
	}


	@Override
	public ProductDto findById(Long id) {
		return ProductDto.convertTo(findId(id));
	}

	@Override
	public Page<ProductDto> findAll(Optional<String> filter, Pageable pageable) {
		List<Product> products = new ArrayList<>();
		if(filter.isPresent()){
			products = productRepository.findBySearchQueryContains(Utils.normalizeToQuery(filter.get()));
		}else {
			products = productRepository.findAll();
		}
		Page<Product> page = new PageImpl<>(products, pageable, products.size());
		return ProductDto.convertTo(page);
	}

	private Product findId(Long id) {
		return productRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Produto não encontrado."));
	}
}
