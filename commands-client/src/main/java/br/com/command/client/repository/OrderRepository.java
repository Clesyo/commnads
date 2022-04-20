package br.com.command.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.command.client.models.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
