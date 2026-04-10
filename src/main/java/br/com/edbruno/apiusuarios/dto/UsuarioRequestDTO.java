package br.com.edbruno.apiusuarios.dto;

// Valida se o email tem formato de email.
import jakarta.validation.constraints.Email;

// Valida se o campo nao veio vazio ou so com espacos.
import jakarta.validation.constraints.NotBlank;

// Valida tamanho minimo e maximo do texto.
import jakarta.validation.constraints.Size;

// Lombok cria construtor com todos os campos.
import lombok.AllArgsConstructor;

// Lombok cria os metodos get.
import lombok.Getter;

// Lombok cria construtor vazio.
import lombok.NoArgsConstructor;

// Lombok cria os metodos set.
import lombok.Setter;

// DTO de entrada.
// Representa os dados que a API recebe no corpo da requisicao.
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequestDTO {

    // O nome e obrigatorio.
    // Tambem precisa ter entre 3 e 100 caracteres.
    @NotBlank(message = "O nome é obrigatório.")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres.")
    private String nome;

    // O email e obrigatorio.
    // Tambem precisa estar em formato valido.
    @NotBlank(message = "O email é obrigatório.")
    @Email(message = "O email informado é inválido.")
    private String email;

    // A senha e obrigatoria.
    // Tambem precisa ter entre 6 e 50 caracteres.
    @NotBlank(message = "A senha é obrigatória.")
    @Size(min = 6, max = 50, message = "A senha deve ter entre 6 e 50 caracteres.")
    private String senha;
}
