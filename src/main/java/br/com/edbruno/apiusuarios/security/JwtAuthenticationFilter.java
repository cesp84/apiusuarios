package br.com.edbruno.apiusuarios.security;

// Service que carrega os dados do usuario para o Spring Security.
import br.com.edbruno.apiusuarios.service.CustomUserDetailsService;

// Service que le e valida o token JWT.
import br.com.edbruno.apiusuarios.service.JwtService;

// Tipos usados pelo filtro da requisicao HTTP.
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Classe do Spring Security que representa um usuario autenticado.
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

// Guarda a autenticacao da requisicao atual.
import org.springframework.security.core.context.SecurityContextHolder;

// Interface com os dados do usuario autenticado.
import org.springframework.security.core.userdetails.UserDetails;

// Adiciona detalhes extras da requisicao ao usuario autenticado.
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

// Diz ao Spring: esta classe e um componente gerenciado.
import org.springframework.stereotype.Component;

// Garante que esse filtro roda uma vez por requisicao.
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

// Filtro JWT.
// Responsabilidade: ler o token da requisicao, validar e autenticar o usuario no Spring Security.
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    // Service que entende o token JWT.
    private final JwtService jwtService;

    // Service que carrega o usuario pelo email.
    private final CustomUserDetailsService customUserDetailsService;

    // Construtor usado pelo Spring para entregar os services prontos.
    public JwtAuthenticationFilter(
            JwtService jwtService,
            CustomUserDetailsService customUserDetailsService) {
        this.jwtService = jwtService;
        this.customUserDetailsService = customUserDetailsService;
    }

    // Este metodo roda a cada requisicao HTTP protegida.
    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {

        // Pega o cabecalho Authorization da requisicao.
        String authHeader = request.getHeader("Authorization");

        // Se nao existir token, ou se nao comecar com "Bearer ", segue a requisicao normal.
        // Nesse caso, este filtro nao autentica ninguem.
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        // Remove a palavra "Bearer " e fica so com o token.
        String token = authHeader.substring(7);

        // Extrai do token o email do usuario.
        String email = jwtService.extractUsername(token);

        // So tenta autenticar se:
        // 1. conseguiu pegar o email do token
        // 2. ainda nao existe autenticacao no contexto atual
        if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            // Busca no banco os dados do usuario dono desse email.
            UserDetails userDetails = customUserDetailsService.loadUserByUsername(email);

            // Confere se o token ainda e valido para esse usuario.
            if (jwtService.isTokenValid(token, userDetails.getUsername())) {

                // Cria um objeto de autenticacao do Spring Security.
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities());

                // Adiciona detalhes da requisicao atual, como origem e sessao.
                authToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request));

                // Guarda a autenticacao no contexto do Spring Security.
                // A partir daqui, a requisicao passa a ser tratada como autenticada.
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        // Continua o fluxo normal da requisicao.
        filterChain.doFilter(request, response);
    }
}
