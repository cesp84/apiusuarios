package br.com.edbruno.apiusuarios.controller;

// Importa o DTO que representa cada erro de validacao.
import br.com.edbruno.apiusuarios.dto.ErroValidacaoDTO;

// Importa status HTTP, como 400 BAD REQUEST.
import org.springframework.http.HttpStatus;

// ResponseEntity permite devolver corpo + status HTTP.
import org.springframework.http.ResponseEntity;

// Excecao disparada quando o @Valid encontra erros no DTO.
import org.springframework.web.bind.MethodArgumentNotValidException;

// Marca o metodo que vai tratar uma excecao especifica.
import org.springframework.web.bind.annotation.ExceptionHandler;

// Diz ao Spring: esta classe trata erros da API de forma global.
import org.springframework.web.bind.annotation.RestControllerAdvice;

// Mantem a ordem em que os erros foram adicionados.
import java.util.LinkedHashMap;

// Lista usada para devolver varios erros.
import java.util.List;

// Map usado para organizar campo -> mensagem.
import java.util.Map;

// Handler global de excecoes.
// Responsabilidade: capturar erros e devolver respostas padronizadas.
@RestControllerAdvice
public class GlobalExceptionHandler {

    // Trata erros de validacao disparados pelo @Valid.
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErroValidacaoDTO>> tratarErroValidacao(MethodArgumentNotValidException ex) {

        // Cria um mapa para organizar os erros por campo.
        // Exemplo: nome -> "O nome e obrigatorio."
        Map<String, String> errosPorCampo = new LinkedHashMap<>();

        // Percorre todos os erros de validacao encontrados pelo Spring.
        ex.getBindingResult()
                .getFieldErrors()

                // Para cada erro:
                // erro.getField() pega o nome do campo
                // erro.getDefaultMessage() pega a mensagem do erro
                //
                // putIfAbsent significa:
                // so adiciona se esse campo ainda nao estiver no mapa.
                // Isso evita repetir varias mensagens do mesmo campo.
                .forEach(erro -> errosPorCampo.putIfAbsent(
                        erro.getField(),
                        erro.getDefaultMessage()));

        // Agora transforma o mapa em uma lista de ErroValidacaoDTO.
        List<ErroValidacaoDTO> erros = errosPorCampo.entrySet()
                .stream()
                .map(entry -> new ErroValidacaoDTO(entry.getKey(), entry.getValue()))
                .toList();

        // Devolve 400 BAD REQUEST com a lista de erros no corpo.
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erros);
    }
}
