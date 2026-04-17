package br.com.edbruno.apiusuarios.util;

import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.security.SecureRandom;
import java.util.Base64;

public class GerarChave {
    public static void main(String[] args) {

        byte[] keyBytes = new byte[32]; // 32 bytes = 256 bits
        new SecureRandom().nextBytes(keyBytes);

        SecretKey key = Keys.hmacShaKeyFor(keyBytes);

        String base64Key = Base64.getEncoder().encodeToString(key.getEncoded());

        System.out.println(base64Key);
    }
}