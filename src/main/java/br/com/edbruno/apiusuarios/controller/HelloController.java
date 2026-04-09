package br.com.edbruno.apiusuarios.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Diz ao Spring: esta classe responde requisicoes HTTP.
@RestController
public class HelloController {

    // Diz ao Spring: quando alguem acessar /hello com GET, execute este metodo.
    @GetMapping("/hello")
    // Este metodo retorna o texto da resposta.
    public String hello() {
        return "Olá, Spring Boot!";
    }
}
