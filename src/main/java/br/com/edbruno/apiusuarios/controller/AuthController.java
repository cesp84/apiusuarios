package br.com.edbruno.apiusuarios.controller;

// Importa o DTO usado quando a API recebe dados de login no body.
import br.com.edbruno.apiusuarios.dto.LoginRequestDTO;

// Importa o DTO usado quando a API devolve dados apos o login.
import br.com.edbruno.apiusuarios.dto.LoginResponseDTO;

// Importa o service que executa a autenticacao.
import br.com.edbruno.apiusuarios.service.AuthService;

// @Valid ativa as validacoes que foram colocadas no DTO.
import jakarta.validation.Valid;

// ResponseEntity permite devolver corpo + status HTTP.
import org.springframework.http.ResponseEntity;

// Importa as anotacoes REST do Spring.
import org.springframework.web.bind.annotation.*;

// Diz ao Spring: esta classe responde requisicoes HTTP.
@RestController

// Diz ao Spring: todos os endpoints desta classe comecam com /auth.
@RequestMapping("/auth")
public class AuthController {

    // Service usado pelo controller para autenticacao.
    private final AuthService authService;

    // Construtor usado pelo Spring para entregar o service pronto.
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // Endpoint POST /auth/login
    // @Valid faz o Spring validar o DTO antes de chamar o service.
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid LoginRequestDTO dto) {
        
        // Chama o service para autenticar o usuario.
        LoginResponseDTO response = authService.login(dto);

        // Se autentico com sucesso, responde 200 OK com os dados do usuario.
        return ResponseEntity.ok(response);
    }
}