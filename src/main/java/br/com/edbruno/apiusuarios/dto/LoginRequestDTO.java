package br.com.edbruno.apiusuarios.dto;

// Valida se o email tem formato de email.
import jakarta.validation.constraints.Email;

// Valida se o campo nao veio vazio ou so com espacos.
import jakarta.validation.constraints.NotBlank;

// Lombok cria os metodos get.
import lombok.Getter;

// Lombok cria os metodos set.
import lombok.Setter;

// DTO de entrada.
// Representa os dados que a API recebe no corpo da requisicao para login.
@Getter
@Setter
public class LoginRequestDTO {

    // O email e obrigatorio.
    // Tambem precisa estar em formato valido.
    @NotBlank(message = "O email é obrigatório.")
    @Email(message = "O email informado é inválido.")
    private String email;

    // A senha e obrigatoria.
    @NotBlank(message = "A senha é obrigatória.")
    private String senha;
}