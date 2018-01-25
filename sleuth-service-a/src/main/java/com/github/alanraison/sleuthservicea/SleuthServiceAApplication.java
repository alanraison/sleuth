package com.github.alanraison.sleuthservicea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class SleuthServiceAApplication {

	public static void main(String[] args) {
		SpringApplication.run(SleuthServiceAApplication.class, args);
	}
}
