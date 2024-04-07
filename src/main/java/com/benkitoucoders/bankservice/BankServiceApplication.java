package com.benkitoucoders.bankservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "The BenkitouCoders Bank Service",
				description = "Backend Rest Apis for TJA Bank",
				version = "v1.0",
				contact = @Contact(
						name = "Rachid Benkitou",
						email = "rachidbenkitou1@gmail.com",
						url = "https://www.linkedin.com/in/rachidbenkitou/"
				),
				license = @License(
						name = "Benkitou Coders",
						url = "https://www.linkedin.com/in/rachidbenkitou/"

				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Benkitou Coders Bank App Documentation",
				url = "https://www.linkedin.com/in/rachidbenkitou/"
		)
)
public class BankServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankServiceApplication.class, args);
	}

}
