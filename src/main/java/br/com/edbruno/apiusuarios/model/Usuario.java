package br.com.edbruno.apiusuarios.model;

// Representa os dados de um usuario dentro da aplicacao.
public class Usuario {

    // Identificador do usuario.
    private Long id;

    // Nome do usuario.
    private String nome;

    // Email do usuario.
    private String email;

    // Construtor vazio.
    // O Spring/Jackson pode usar este construtor para montar um Usuario a partir de
    // JSON.
    public Usuario() {
    }

    // Construtor com todos os campos.
    // Ajuda a criar um usuario ja preenchido pelo codigo Java.
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