package br.com.edbruno.apiusuarios.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
<<<<<<< HEAD
 * DTO (Data Transfer Object) para resposta de autenticação/login.
 * <p>
 * Este objeto é retornado ao cliente após uma autenticação bem-sucedida,
 * contendo as informações necessárias para acesso às rotas protegidas da API.
 * </p>
 *
 * @author edbruno
 * @see LoginRequestDTO
=======
 * DTO (Data Transfer Object) para resposta de autenticação.
 * <p>
 * Esta classe representa a estrutura da resposta retornada após um login bem-sucedido,
 * contendo o token de acesso e o tipo de autenticação.
 * </p>
>>>>>>> documentacao-loginresponsedto-f2edd
 */
@Getter
@AllArgsConstructor
public class LoginResponseDTO {

    /**
<<<<<<< HEAD
     * Token de acesso JWT gerado após autenticação bem-sucedida.
     * <p>
     * Este token deve ser incluído no cabeçalho das requisições subsequentes
     * para acessar endpoints protegidos, geralmente no formato:
     * {@code Authorization: Bearer <token>}
     * </p>
=======
     * Token de acesso gerado após autenticação bem-sucedida.
     * Utilizado para autorizar requisições subsequentes à API.
>>>>>>> documentacao-loginresponsedto-f2edd
     */
    private String token;

    /**
<<<<<<< HEAD
     * Tipo do token de autenticação.
     * <p>
     * Indica o esquema de autenticação utilizado. Normalmente retorna "Bearer"
     * para APIs que utilizam JWT (JSON Web Token).
     * </p>
     * <p>
     * Exemplo de uso no cabeçalho HTTP:
     * {@code Authorization: Bearer <token>}
     * </p>
=======
     * Tipo do token de autenticação (ex: "Bearer").
     * Indica o esquema de autenticação a ser utilizado nas requisições.
>>>>>>> documentacao-loginresponsedto-f2edd
     */
    private String tipo;
}