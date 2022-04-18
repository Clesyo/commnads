package br.com.command.client.seeders;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.command.client.models.City;

public interface CityRepository extends JpaRepository<City, Long> {

}
