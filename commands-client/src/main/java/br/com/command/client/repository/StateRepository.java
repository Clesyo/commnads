package br.com.command.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.command.client.models.State;

public interface StateRepository extends JpaRepository<State, Long> {

}
