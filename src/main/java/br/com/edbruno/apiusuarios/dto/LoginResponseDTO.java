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

     // Token JWT gerado apos o login.
     private String token;

     // Tipo do token.
     // Neste projeto, o valor esperado e "Bearer".
     private String tipo;
}
