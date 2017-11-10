package br.com.tartaroshamburgueria.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import br.com.tartaroshamburgueria.api.config.property.TartarosApiProperty;

@SpringBootApplication
@EnableConfigurationProperties(TartarosApiProperty.class)
public class TartarosApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TartarosApiApplication.class, args);
	}
}
