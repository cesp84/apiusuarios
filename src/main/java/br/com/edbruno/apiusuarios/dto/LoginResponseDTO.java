package br.com.edbruno.apiusuarios.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * DTO (Data Transfer Object) para resposta de autenticação.
 * <p>
 * Esta classe representa a estrutura da resposta retornada após um login bem-sucedido,
 * contendo o token de acesso e o tipo de autenticação.
 * </p>
 */
@Getter
@AllArgsConstructor
public class LoginResponseDTO {

    /**
     * Token de acesso gerado após autenticação bem-sucedida.
     * Utilizado para autorizar requisições subsequentes à API.
     */
    private String token;

    /**
     * Tipo do token de autenticação (ex: "Bearer").
     * Indica o esquema de autenticação a ser utilizado nas requisições.
     */
    private String tipo;
}