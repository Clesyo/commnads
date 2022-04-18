package br.com.command.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.command.client.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
