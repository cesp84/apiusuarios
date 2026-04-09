package br.com.edbruno.apiusuarios.dto;

// Diz ao Lombok: cria construtor com todos os campos.
import lombok.AllArgsConstructor;

// Diz ao Lombok: cria os metodos get.
import lombok.Getter;

// Diz ao Lombok: cria construtor vazio.
import lombok.NoArgsConstructor;

// Diz ao Lombok: cria os metodos set.
import lombok.Setter;

// DTO de saida.
// Esta classe representa os dados que a API devolve na resposta.
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioResponseDTO {

    // Id do usuario devolvido na resposta.
    private Long id;

    // Nome devolvido na resposta.
    private String nome;

    // Email devolvido na resposta.
    private String email;
}
