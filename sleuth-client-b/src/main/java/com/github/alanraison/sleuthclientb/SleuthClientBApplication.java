package com.github.alanraison.sleuthclientb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SleuthClientBApplication {

	@RequestMapping("/")
	public String basic() {
		return "OK";
	}

	public static void main(String[] args) {
		SpringApplication.run(SleuthClientBApplication.class, args);
	}
}
