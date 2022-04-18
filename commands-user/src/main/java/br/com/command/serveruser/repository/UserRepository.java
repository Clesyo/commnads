package br.com.command.serveruser.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.command.serveruser.models.User;

public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findByEmail(String email);

}
