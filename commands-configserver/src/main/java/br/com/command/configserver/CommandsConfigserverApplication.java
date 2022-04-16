package br.com.command.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class CommandsConfigserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommandsConfigserverApplication.class, args);
	}

}
