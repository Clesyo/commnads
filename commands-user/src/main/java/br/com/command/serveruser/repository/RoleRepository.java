package br.com.command.serveruser.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.command.serveruser.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Optional<Role> findByName(String name);
}
