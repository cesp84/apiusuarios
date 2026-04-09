package br.com.edbruno.apiusuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Diz ao Spring Boot: esta e a classe principal da aplicacao.
// A partir daqui o Spring prepara o projeto e procura outras classes, como controllers.
@SpringBootApplication
public class ApiusuariosApplication {

	// Este e o primeiro metodo executado quando a aplicacao comeca.
	public static void main(String[] args) {

		// Liga a aplicacao Spring Boot.
		SpringApplication.run(ApiusuariosApplication.class, args);
	}

}
