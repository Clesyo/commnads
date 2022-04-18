package br.com.command.gatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CommandsGatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommandsGatewayServerApplication.class, args);
	}

}
