package br.com.edbruno.apiusuarios.dto;

// Diz ao Lombok: cria construtor com todos os campos.
import lombok.AllArgsConstructor;

// Diz ao Lombok: cria os metodos get.
import lombok.Getter;

// Diz ao Lombok: cria construtor vazio.
import lombok.NoArgsConstructor;

// Diz ao Lombok: cria os metodos set.
import lombok.Setter;

// DTO de entrada.
// Esta classe representa os dados que a API recebe no corpo da requisicao.
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequestDTO {

    // Nome recebido no JSON.
    private String nome;

    // Email recebido no JSON.
    private String email;

    // Senha recebida no JSON.
    // Observacao importante: no estado atual do projeto, a senha ainda nao esta sendo salva no model.
    private String senha;
}
