package br.com.command.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.command.client.models.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
