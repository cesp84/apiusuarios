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
// Ele coordena o processo de login.
import org.springframework.security.authentication.AuthenticationManager;

// Provedor de autenticacao que usa o banco de dados para buscar usuarios.
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

// Interface para obter o AuthenticationManager configurado.
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;

// Classe principal para configurar a seguranca das requisicoes HTTP.
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

// Enum para definir politica de sessao.
// Aqui usamos stateless porque a API trabalha com token.
import org.springframework.security.config.http.SessionCreationPolicy;

// Implementacao do BCrypt para criptografar senhas.
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// Interface para codificador de senhas.
import org.springframework.security.crypto.password.PasswordEncoder;

// Interface que representa a configuracao final da seguranca da aplicacao.
import org.springframework.security.web.SecurityFilterChain;

// Filtro padrao do Spring para autenticacao por username/senha.
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// Diz ao Spring: esta classe contem configuracoes de seguranca.
@Configuration
public class SecurityConfig {

// Filtro responsavel por validar tokens JWT nas requisicoes.
// Ele roda antes do controller.
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    // Servico que carrega os dados do usuario para o Spring Security.
    private final CustomUserDetailsService customUserDetailsService;

    // Construtor usado pelo Spring para injetar as dependencias.
    public SecurityConfig(
            JwtAuthenticationFilter jwtAuthenticationFilter,
            CustomUserDetailsService customUserDetailsService) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        this.customUserDetailsService = customUserDetailsService;
    }

    // Bean que define como as senhas serão criptografadas.
    // BCrypt e um dos algoritmos mais usados para senha.
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Bean que monta o provedor de autenticacao.
    // Ele usa o service para buscar usuario e o encoder para comparar senha.
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(customUserDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    // Bean que entrega o AuthenticationManager pronto para outras classes.
    // O AuthService usa isso no login.
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    // Bean principal da seguranca HTTP.
    // Aqui definimos quem entra sem login e quem precisa de token.
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Desabilita CSRF.
                // Em API com JWT isso normalmente fica desligado.
                .csrf(csrf -> csrf.disable())
                // Diz que a aplicacao nao vai guardar sessao no servidor.
                // Cada requisicao precisa vir com o token.
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // Define as regras de acesso das rotas.
                .authorizeHttpRequests(auth -> auth
                        // Libera as rotas de autenticacao e o console do H2.
                        .requestMatchers("/auth/**", "/h2-console/**").permitAll()
                        // Libera o cadastro de usuario sem login.
                        .requestMatchers(HttpMethod.POST, "/usuarios").permitAll()
                        // Todo o resto exige autenticacao.
                        .anyRequest().authenticated())
                // Registra o provedor que sabe buscar usuario e validar senha.
                .authenticationProvider(authenticationProvider())
                // Coloca o filtro JWT antes do filtro padrao do Spring Security.
                // Assim o token e lido antes de chegar na autenticacao normal.
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        // Libera o uso de frames.
        // Isso e necessario para o H2 Console abrir no navegador.
        http.headers(headers -> headers.frameOptions(frame -> frame.disable()));

        // Finaliza e devolve a configuracao pronta da seguranca.
        return http.build();
    }
}
