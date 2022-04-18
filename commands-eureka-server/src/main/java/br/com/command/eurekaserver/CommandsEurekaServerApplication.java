package br.com.command.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CommandsEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommandsEurekaServerApplication.class, args);
	}

}
