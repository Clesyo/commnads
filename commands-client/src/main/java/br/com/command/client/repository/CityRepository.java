package br.com.command.client.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.command.client.models.City;

public interface CityRepository extends JpaRepository<City, Long> {

	Optional<City> findByIbgeCode(Integer ibgeCode);

}
