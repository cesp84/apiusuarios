package br.com.edbruno.apiusuarios.dto;

// Lombok cria construtor com todos os campos.
import lombok.AllArgsConstructor;

// Lombok cria os metodos get.
import lombok.Getter;

// DTO de erro de validacao.
// Esta classe representa um erro devolvido quando o request e invalido.
@Getter
@AllArgsConstructor
public class ErroValidacaoDTO {

    // Nome do campo que falhou na validacao.
    private String campo;

    // Mensagem explicando o erro.
    private String mensagem;
}
