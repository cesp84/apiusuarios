package br.com.edbruno.apiusuarios.model;

// Diz ao JPA: esta classe representa uma tabela no banco.
import jakarta.persistence.Entity;

// Diz ao JPA: o valor deste campo sera gerado automaticamente.
import jakarta.persistence.GeneratedValue;

// Define a estrategia usada para gerar o id.
import jakarta.persistence.GenerationType;

// Diz ao JPA: este campo e a chave/identificador da tabela.
import jakarta.persistence.Id;

// Diz ao Lombok: crie automaticamente o construtor com todos os atributos.
import lombok.AllArgsConstructor;

// Diz ao Lombok: crie automaticamente os metodos get.
import lombok.Getter;

// Diz ao Lombok: crie automaticamente o construtor vazio.
import lombok.NoArgsConstructor;

// Diz ao Lombok: crie automaticamente os metodos set.
import lombok.Setter;

// Marca esta classe como uma entidade do banco.
// Em ideia simples: Usuario vira uma tabela controlada pelo JPA.
@Entity

// Gera automaticamente getId(), getNome(), getEmail() e getSenha().
@Getter

// Gera automaticamente setId(), setNome(), setEmail() e setSenha().
@Setter

// Gera automaticamente o construtor vazio.
@NoArgsConstructor

// Gera automaticamente um construtor com todos os campos.
@AllArgsConstructor
public class Usuario {

    // Marca o id como identificador do usuario no banco.
    @Id

    // Pede para o banco gerar o id automaticamente.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Guarda o nome do usuario.
    private String nome;

    // Guarda o email do usuario.
    private String email;

    // Guarda a senha do usuario.
    private String senha;
}
