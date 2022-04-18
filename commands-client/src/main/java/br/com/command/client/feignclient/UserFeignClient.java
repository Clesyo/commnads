package br.com.command.client.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.command.client.dtos.UserDto;
import br.com.command.client.forms.UserForm;

@Component
@FeignClient(name = "command-user", path = "/user")
public interface UserFeignClient {

	@PostMapping
	UserDto save(@RequestBody UserForm form);
	
	@GetMapping("/{publicId}")
	UserDto findPublicId(@PathVariable String publicId);
	
}
