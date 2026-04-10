package br.com.edbruno.apiusuarios.controller;

// DTO usado quando a API recebe os dados de login.
import br.com.edbruno.apiusuarios.dto.LoginRequestDTO;

// DTO usado na resposta de login.
import br.com.edbruno.apiusuarios.dto.LoginResponseDTO;

// Service que contem a regra de login.
import br.com.edbruno.apiusuarios.service.UsuarioService;

// @Valid ativa as validacoes do LoginRequestDTO.
import jakarta.validation.Valid;

// ResponseEntity permite devolver corpo + status HTTP.
import org.springframework.http.ResponseEntity;

// Importa as anotacoes REST do Spring.
import org.springframework.web.bind.annotation.*;

// Diz ao Spring: esta classe responde requisicoes HTTP.
@RestController

// Diz ao Spring: todas as rotas desta classe comecam com /auth.
@RequestMapping("/auth")
public class AuthController {

    // Service usado pelo controller.
    private final UsuarioService usuarioService;

    // Construtor usado pelo Spring para entregar o service pronto.
    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // Endpoint POST /auth/login
    // Recebe email e senha, valida e tenta fazer login.
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid LoginRequestDTO dto) {

        // Chama o service para executar a regra de login.
        LoginResponseDTO response = usuarioService.login(dto);

        // Se deu certo, devolve 200 OK com os dados do login.
        return ResponseEntity.ok(response);
    }
}
