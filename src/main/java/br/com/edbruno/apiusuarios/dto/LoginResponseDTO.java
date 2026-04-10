package br.com.edbruno.apiusuarios.dto;

// Lombok cria construtor com todos os campos.
import lombok.AllArgsConstructor;

// Lombok cria os metodos get.
import lombok.Getter;

// DTO de saida do login.
// Esta classe representa o que a API devolve quando o login da certo.
@Getter
@AllArgsConstructor
public class LoginResponseDTO {

    // Mensagem simples de sucesso.
    private String mensagem;

    // Id do usuario logado.
    private Long id;

    // Nome do usuario logado.
    private String nome;
}
