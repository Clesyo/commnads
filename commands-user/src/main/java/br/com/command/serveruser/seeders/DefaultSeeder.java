package br.com.command.serveruser.seeders;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.command.serveruser.enums.UserType;
import br.com.command.serveruser.models.Role;
import br.com.command.serveruser.repository.RoleRepository;

@Service
public class DefaultSeeder {

	private static final Logger LOGGER = LoggerFactory.getLogger(DefaultSeeder.class);
	
	@Autowired
	private RoleRepository roleRepository;
	
	public void seedRole() {
		if(roleRepository.count() == 0) {
			LOGGER.info(">>>> Creating default roles");
			var types = Arrays.asList(UserType.values());
			types.stream().map(type -> new Role(type.name())).forEach(role -> roleRepository.save(role));
			LOGGER.info(">>>> Default roles created");
		}
	}
}
