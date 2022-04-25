package br.com.command.client.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.command.client.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findBySearchQueryContains(String filter);
}
