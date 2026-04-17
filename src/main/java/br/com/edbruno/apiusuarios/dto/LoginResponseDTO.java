package br.com.edbruno.apiusuarios.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * DTO (Data Transfer Object) para resposta de autenticação/login.
 * <p>
 * Este objeto é retornado ao cliente após uma autenticação bem-sucedida,
 * contendo as informações necessárias para acesso às rotas protegidas da API.
 * </p>
 *
 * @author edbruno
 * @see LoginRequestDTO
 */
@Getter
@AllArgsConstructor
public class LoginResponseDTO {

    /**
     * Token de acesso JWT gerado após autenticação bem-sucedida.
     * <p>
     * Este token deve ser incluído no cabeçalho das requisições subsequentes
     * para acessar endpoints protegidos, geralmente no formato:
     * {@code Authorization: Bearer <token>}
     * </p>
     */
    private String token;

    /**
     * Tipo do token de autenticação.
     * <p>
     * Indica o esquema de autenticação utilizado. Normalmente retorna "Bearer"
     * para APIs que utilizam JWT (JSON Web Token).
     * </p>
     * <p>
     * Exemplo de uso no cabeçalho HTTP:
     * {@code Authorization: Bearer <token>}
     * </p>
     */
    private String tipo;
}