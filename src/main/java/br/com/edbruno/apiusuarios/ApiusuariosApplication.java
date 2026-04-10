package br.com.edbruno.apiusuarios;

// Classe usada para iniciar a aplicacao Spring Boot.
import org.springframework.boot.SpringApplication;

// Anotacao principal do Spring Boot.
// Ela liga a configuracao automatica e a leitura dos componentes do projeto.
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
