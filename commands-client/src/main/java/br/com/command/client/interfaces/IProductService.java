package br.com.command.client.interfaces;

import br.com.command.client.dtos.ProductDto;
import br.com.command.client.forms.ProductForm;

public interface IProductService {

	ProductDto save(ProductForm form);
}
