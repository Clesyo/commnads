package br.com.command.client.interfaces;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.command.client.dtos.ProductDto;
import br.com.command.client.forms.ProductForm;

public interface IProductService {

	ProductDto save(ProductForm form);

	ProductDto update(Long id, ProductForm form);

	ProductDto findById(Long id);

	Page<ProductDto> findAll(Optional<String> filter, Pageable pageable);
}
