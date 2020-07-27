package com.saurabhsomani;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.saurabhsomani.domain.Product;
import com.saurabhsomani.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class JsondbApplication {

	public static void main(String[] args) {

		SpringApplication.run(JsondbApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(ProductService productService){ //will help us when the application starts up
		return args -> { //functional interface
			//read json and write to db
			ObjectMapper mapper = new ObjectMapper();
			//We want a list of products
			TypeReference<List<Product>> typeReference = new TypeReference<List<Product>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/product.json");
			try{
				//mapper helps us map json structure to the domain object
				List<Product> products = mapper.readValue(inputStream, typeReference);
				productService.save(products);
				System.out.println("Products Saved!");
			} catch (IOException e){
				System.out.println("Unable to save products: " + e.getMessage());
			}
		};
	}
}
