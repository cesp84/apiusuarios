// package br.com.edbruno.apiusuarios.model;

// // Representa os dados de um usuario dentro da aplicacao.
// public class Usuario {

//     // Identificador do usuario.
//     private Long id;

//     // Nome do usuario.
//     private String nome;

//     // Email do usuario.
//     private String email;

//     // Construtor vazio.
//     // O Spring/Jackson pode usar este construtor para montar um Usuario a partir de
//     // JSON.
//     public Usuario() {
//     }

//     // Construtor com todos os campos.
//     // Ajuda a criar um usuario ja preenchido pelo codigo Java.
//     public Usuario(Long id, String nome, String email) {
//         this.id = id;
//         this.nome = nome;
//         this.email = email;
//     }

//     // Retorna o id do usuario.
//     public Long getId() {
//         return id;
//     }

//     // Retorna o nome do usuario.
//     public String getNome() {
//         return nome;
//     }

//     // Retorna o email do usuario.
//     public String getEmail() {
//         return email;
//     }

//     // Altera o id do usuario.
//     public void setId(Long id) {
//         this.id = id;
//     }

//     // Altera o nome do usuario.
//     public void setNome(String nome) {
//         this.nome = nome;
//     }

//     // Altera o email do usuario.
//     public void setEmail(String email) {
//         this.email = email;
//     }
// }

// package br.com.edbruno.apiusuarios.model;

// // Importa a anotacao que cria um construtor com todos os atributos.
// import lombok.AllArgsConstructor;

// // Importa a anotacao que cria os getters.
// import lombok.Getter;

// // Importa a anotacao que cria um construtor vazio.
// import lombok.NoArgsConstructor;

// // Importa a anotacao que cria os setters.
// import lombok.Setter;

// // Diz ao Lombok: crie automaticamente getId(), getNome() e getEmail().
// @Getter
// // Diz ao Lombok: crie automaticamente setId(), setNome() e setEmail().
// @Setter
// // Diz ao Lombok: crie automaticamente o construtor vazio Usuario().
// @NoArgsConstructor
// // Diz ao Lombok: crie automaticamente o construtor com id, nome e email.
// @AllArgsConstructor
// // Esta classe representa um usuario dentro da nossa API.
// public class Usuario {

//     // Guarda o identificador do usuario.
//     private Long id;

//     // Guarda o nome do usuario.
//     private String nome;

//     // Guarda o email do usuario.
//     private String email;
// }

package br.com.edbruno.apiusuarios.model;

// Diz ao JPA: esta classe representa uma tabela no banco.
import jakarta.persistence.Entity;

// Diz ao JPA: o valor deste campo sera gerado automaticamente.
import jakarta.persistence.GeneratedValue;

// Define a estrategia usada para gerar o id.
import jakarta.persistence.GenerationType;

// Diz ao JPA: este campo e a chave/identificador da tabela.
import jakarta.persistence.Id;

// Marca esta classe como uma entidade do banco.
// Em ideia simples: Usuario vira uma tabela controlada pelo JPA.
@Entity
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

    // Construtor vazio.
    // O Spring/Jackson/JPA precisam dele para montar o objeto automaticamente.
    public Usuario() {
    }

    // Construtor completo.
    // Ajuda quando quisermos criar um Usuario ja preenchido no codigo Java.
    public Usuario(Long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    // Retorna o id do usuario.
    public Long getId() {
        return id;
    }

    // Retorna o nome do usuario.
    public String getNome() {
        return nome;
    }

    // Retorna o email do usuario.
    public String getEmail() {
        return email;
    }

    // Altera o id do usuario.
    public void setId(Long id) {
        this.id = id;
    }

    // Altera o nome do usuario.
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Altera o email do usuario.
    public void setEmail(String email) {
        this.email = email;
    }
}
