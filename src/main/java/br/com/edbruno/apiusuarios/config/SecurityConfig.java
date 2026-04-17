package br.com.edbruno.apiusuarios.config;

// Importa o filtro que valida o token JWT em cada requisicao.
import br.com.edbruno.apiusuarios.security.JwtAuthenticationFilter;

// Importa o servico que carrega dados do usuario do banco de dados.
import br.com.edbruno.apiusuarios.service.CustomUserDetailsService;

// Anotacao para registrar beans no contexto do Spring.
import org.springframework.context.annotation.Bean;

// Anotacao para marcar esta classe como configuracao do Spring.
import org.springframework.context.annotation.Configuration;

// Enum usado para definir tipos de metodos HTTP nas regras de autorizacao.
import org.springframework.http.HttpMethod;

// Gerenciador de autenticacao do Spring Security.
import org.springframework.security.authentication.AuthenticationManager;

// Provedor de autenticacao que usa DAO para buscar usuarios.
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

// Interface para obter o AuthenticationManager configurado.
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;

// Classe principal para configurar seguranca HTTP.
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

// Enum para definir politica de sessao (stateless para API REST).
import org.springframework.security.config.http.SessionCreationPolicy;

// Implementacao do BCrypt para criptografar senhas.
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// Interface para codificador de senhas.
import org.springframework.security.crypto.password.PasswordEncoder;

// Interface que define a cadeia de filtros de seguranca.
import org.springframework.security.web.SecurityFilterChain;

// Filtro padrao do Spring para autenticacao por username/senha.
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// Diz ao Spring: esta classe contem configuracoes de seguranca.
@Configuration
public class SecurityConfig {

    // Filtro responsavel por validar tokens JWT nas requisicoes.
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    // Servico que carrega detalhes do usuario para autenticacao.
    private final CustomUserDetailsService customUserDetailsService;

    // Construtor usado pelo Spring para injetar as dependencias.
    public SecurityConfig(
            JwtAuthenticationFilter jwtAuthenticationFilter,
            CustomUserDetailsService customUserDetailsService) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        this.customUserDetailsService = customUserDetailsService;
    }

    // Bean que define o algoritmo de criptografia de senhas (BCrypt).
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Bean que configura o provedor de autenticacao com servico e encoder.
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(customUserDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    // Bean que expoe o AuthenticationManager para uso externo (ex: auth manual).
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    // Bean que configura a cadeia de filtros de seguranca da aplicacao.
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Desabilita protecao CSRF (necessario para APIs stateless).
                .csrf(csrf -> csrf.disable())
                // Define que nao haverá sessao do lado do servidor (stateless).
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // Configura quais endpoints sao publicos ou exigem autenticacao.
                .authorizeHttpRequests(auth -> auth
                        // Permite acesso sem autenticacao para login e H2 Console.
                        .requestMatchers("/auth/**", "/h2-console/**").permitAll()
                        // Permite cadastro de usuario sem autenticacao.
                        .requestMatchers(HttpMethod.POST, "/usuarios").permitAll()
                        // Todas as outras requisicoes exigem autenticacao.
                        .anyRequest().authenticated())
                // Registra o provedor de autenticacao configurado.
                .authenticationProvider(authenticationProvider())
                // Adiciona o filtro JWT antes do filtro de autenticacao padrao.
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        // Habilita o uso de frames (necessario para o H2 Console funcionar).
        http.headers(headers -> headers.frameOptions(frame -> frame.disable()));

        // Constroi e retorna a cadeia de seguranca configurada.
        return http.build();
    }
}