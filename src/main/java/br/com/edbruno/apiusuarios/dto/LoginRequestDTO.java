package br.com.edbruno.apiusuarios.dto;

// Valida se o email tem formato correto.
import jakarta.validation.constraints.Email;

// Valida se o campo nao veio vazio.
import jakarta.validation.constraints.NotBlank;

// Lombok cria os metodos get.
import lombok.Getter;

// Lombok cria os metodos set.
import lombok.Setter;

// DTO de entrada do login.
// Representa os dados que a API recebe no endpoint /auth/login.
@Getter
@Setter
public class LoginRequestDTO {

    // O email e obrigatorio e precisa estar em formato valido.
    @NotBlank(message = "O email é obrigatório.")
    @Email(message = "O email é inválido.")
    private String email;

    // A senha e obrigatoria.
    @NotBlank(message = "A senha é obrigatória.")
    private String senha;
}
