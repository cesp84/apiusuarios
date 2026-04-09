package br.com.edbruno.apiusuarios.controller;

// Importa a anotacao usada para criar endpoints do tipo GET.
import org.springframework.web.bind.annotation.GetMapping;

// Importa a anotacao usada para criar um controller REST.
import org.springframework.web.bind.annotation.RestController;

// Diz ao Spring: esta classe responde requisicoes HTTP.
@RestController
// Agrupa endpoints simples de estudo.
public class HelloController {

    // Diz ao Spring: quando alguem acessar /hello com GET, execute este metodo.
    @GetMapping("/hello")
    // Este metodo retorna o texto da resposta.
    public String hello() {
        // Texto enviado para quem chamou o endpoint /hello.
        return "Olá, Spring Boot!";
    }

    // Diz ao Spring: quando alguem acessar /nome com GET, execute este metodo.
    @GetMapping("/nome")
    // Este metodo retorna um nome fixo como resposta.
    public String nome() {
        // Texto enviado para quem chamou o endpoint /nome.
        return "Edbruno";
    }

    // Diz ao Spring: quando alguem acessar /mensagem com GET, execute este metodo.
    @GetMapping("/mensagem")
    // Este metodo retorna uma mensagem simples de estudo.
    public String mensagem() {
        // Texto enviado para quem chamou o endpoint /mensagem.
        return "Estou aprendendo Spring Boot";
    }
}
