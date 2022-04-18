package br.com.command.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.command.client.models.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
