package br.com.command.serveruser;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import br.com.command.serveruser.seeders.DefaultSeeder;

@SpringBootApplication
@EnableEurekaClient
public class CommandsUserApplication {

	@Autowired
	private DefaultSeeder defaultSeeder; 
	
	public static void main(String[] args) {
		SpringApplication.run(CommandsUserApplication.class, args);
	}

	@PostConstruct
	public void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		defaultSeeder.seedRole();
	}
}
