package br.com.edbruno.apiusuarios.service;

// Representa os dados guardados dentro do token JWT.
import io.jsonwebtoken.Claims;

// Classe principal da biblioteca JWT.
import io.jsonwebtoken.Jwts;

// Ajuda a decodificar a chave secreta em Base64.
import io.jsonwebtoken.io.Decoders;

// Ajuda a montar a chave usada para assinar o token.
import io.jsonwebtoken.security.Keys;

// Lê valores do application.properties.
import org.springframework.beans.factory.annotation.Value;

// Marca esta classe como service do Spring.
import org.springframework.stereotype.Service;

// Tipo de chave usado para assinar e validar o token.
import javax.crypto.SecretKey;

// Usado para definir data de criação e expiração do token.
import java.util.Date;

// Permite extrair partes diferentes do token com reuso.
import java.util.function.Function;

// Diz ao Spring: esta classe cuida das operações com JWT.
@Service
public class JwtService {

    // Lê a chave secreta configurada no application.properties.
    @Value("${jwt.secret}")
    private String secretKey;

    // Lê o tempo de expiração do token.
    @Value("${jwt.expiration}")
    private long jwtExpiration;

    // Gera um token JWT usando o email como identificador do usuário.
    public String generateToken(String email) {

        // Guarda o momento atual.
        Date agora = new Date();

        // Calcula quando o token vai expirar.
        Date expiracao = new Date(agora.getTime() + jwtExpiration);

        // Monta e assina o token.
        return Jwts.builder()
                // Define quem é o dono do token.
                .subject(email)

                // Define quando o token foi criado.
                .issuedAt(agora)

                // Define quando o token deixa de valer.
                .expiration(expiracao)

                // Assina o token com a chave secreta.
                .signWith(getSignInKey())
                .compact();
    }

    // Extrai o email guardado dentro do token.
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    // Valida se o token pertence ao email informado e se ainda nao expirou.
    public boolean isTokenValid(String token, String email) {
        String username = extractUsername(token);
        return username.equals(email) && !isTokenExpired(token);
    }

    // Verifica se a data de expiração já passou.
    private boolean isTokenExpired(String token) {
        return extractClaim(token, Claims::getExpiration).before(new Date());
    }

    // Metodo generico para extrair uma informação especifica do token.
    private <T> T extractClaim(String token, Function<Claims, T> resolver) {
        Claims claims = extractAllClaims(token);
        return resolver.apply(claims);
    }

    // Lê todo o conteúdo do token já validando a assinatura.
    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(getSignInKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    // Converte a chave secreta em texto para o formato que o JWT precisa.
    private SecretKey getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
