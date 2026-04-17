package br.com.edbruno.apiusuarios.util;

// Classe da biblioteca JWT para criar chave compatível.
import io.jsonwebtoken.security.Keys;

// Tipo de chave usada para assinar o token.
import javax.crypto.SecretKey;

// Gera números aleatórios seguros.
import java.security.SecureRandom;

// Converte a chave binária para texto.
import java.util.Base64;

// Classe utilitária para gerar uma chave secreta JWT.
public class GerarChave {

    // Metodo main para executar a geração da chave pelo terminal.
    public static void main(String[] args) {

        // Cria um espaço de 32 bytes.
        // 32 bytes = 256 bits.
        byte[] keyBytes = new byte[32];

        // Preenche os bytes com valores aleatórios seguros.
        new SecureRandom().nextBytes(keyBytes);

        // Monta a chave que o JWT consegue usar.
        SecretKey key = Keys.hmacShaKeyFor(keyBytes);

        // Converte a chave para Base64 para ficar fácil copiar para o properties.
        String base64Key = Base64.getEncoder().encodeToString(key.getEncoded());

        // Mostra a chave gerada no terminal.
        System.out.println(base64Key);
    }
}
