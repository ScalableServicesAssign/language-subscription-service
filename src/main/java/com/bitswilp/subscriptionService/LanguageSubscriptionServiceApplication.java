package com.bitswilp.subscriptionService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableDiscoveryClient
@OpenAPIDefinition(
	    info = @Info(
	        title = "Language Subscription Microservice Swagger",
	        version = "v1",
	        description = "API documentation for My Microservice"
	    )
	)
public class LanguageSubscriptionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LanguageSubscriptionServiceApplication.class, args);
	}

}
