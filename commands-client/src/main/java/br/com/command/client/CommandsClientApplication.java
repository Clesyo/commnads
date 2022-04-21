package br.com.command.client;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import br.com.command.client.seeders.DefaultSeeder;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class CommandsClientApplication {

	@Autowired
	private DefaultSeeder seeder;

	public static void main(String[] args) {
		SpringApplication.run(CommandsClientApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@PostConstruct
	public void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		seeder.seedStatesAndCities();
	}
}
