package com.cristobits0101.springboot_webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication

// Refencia al archivo de propiedades personalizado.
@PropertySources({
		@PropertySource(value = "classpath:values.properties", encoding = "UTF-8")
})

public class SpringbootWebappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWebappApplication.class, args);
	}

}
