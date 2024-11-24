package com.teoh.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
    info = @Info(
        title = "Teoh API",
        version = "v1",
        description = "API documentation for Teoh project"
    )
)

@SpringBootApplication
public class TeohApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeohApiApplication.class, args);
	}

}
