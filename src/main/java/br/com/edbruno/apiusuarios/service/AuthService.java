package br.com.edbruno.apiusuarios.service;

// DTO que recebe os dados enviados no login.
import br.com.edbruno.apiusuarios.dto.LoginRequestDTO;

// DTO devolvido depois que o login da certo.
import br.com.edbruno.apiusuarios.dto.LoginResponseDTO;

// Componente do Spring Security que faz a autenticacao.
import org.springframework.security.authentication.AuthenticationManager;

// Objeto usado para entregar email e senha ao Spring Security.
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

// Marca esta classe como service do Spring.
import org.springframework.stereotype.Service;

// Diz ao Spring: esta classe cuida da autenticacao/login.
@Service
public class AuthService {

    // Responsavel por validar email e senha.
    private final AuthenticationManager authenticationManager;

    // Responsavel por gerar o token JWT.
    private final JwtService jwtService;

    // Construtor usado pelo Spring para entregar as dependencias prontas.
    public AuthService(
            AuthenticationManager authenticationManager,
            JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    // Faz o login do usuario.
    // Se o email e a senha estiverem certos, gera um token JWT.
    public LoginResponseDTO login(LoginRequestDTO dto) {

        // Entrega email e senha ao Spring Security para autenticacao.
        // Se estiver errado, o Spring lança erro.
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getSenha()));

        // Depois da autenticacao, gera um token usando o email do usuario.
        String token = jwtService.generateToken(dto.getEmail());

        // Devolve o token e o tipo esperado no cabecalho Authorization.
        return new LoginResponseDTO(token, "Bearer");
    }
}
