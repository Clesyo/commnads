package br.com.command.client.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.command.client.models.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

	Optional<Restaurant> findByCnpj(String cnpj);

	Optional<Restaurant> findByCnpjAndIdNot(String cnpj, Long id);

}
