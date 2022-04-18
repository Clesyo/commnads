package br.com.command.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.command.client.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
