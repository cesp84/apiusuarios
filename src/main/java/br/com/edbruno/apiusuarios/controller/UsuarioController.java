package br.com.edbruno.apiusuarios.controller;

// Importa o DTO usado quando a API recebe dados no body.
import br.com.edbruno.apiusuarios.dto.UsuarioRequestDTO;

// Importa o DTO usado quando a API devolve dados na resposta.
import br.com.edbruno.apiusuarios.dto.UsuarioResponseDTO;

// Importa o service que executa as operacoes.
import br.com.edbruno.apiusuarios.service.UsuarioService;

// @Valid ativa as validacoes que foram colocadas no DTO.
import jakarta.validation.Valid;

// Importa status HTTP, como 201 CREATED.
import org.springframework.http.HttpStatus;

// ResponseEntity permite devolver corpo + status HTTP.
import org.springframework.http.ResponseEntity;

// Importa as anotacoes REST do Spring.
import org.springframework.web.bind.annotation.*;

// Importa List para devolver varios itens.
import java.util.List;

// Diz ao Spring: esta classe responde requisicoes HTTP.
@RestController

// Diz ao Spring: todos os endpoints desta classe comecam com /usuarios.
@RequestMapping("/usuarios")
public class UsuarioController {

    // Service usado pelo controller.
    private final UsuarioService usuarioService;

    // Construtor usado pelo Spring para entregar o service pronto.
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // Endpoint GET /usuarios
    // Devolve uma lista de UsuarioResponseDTO.
    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> listar() {

        // Responde 200 OK com a lista de usuarios no corpo.
        return ResponseEntity.ok(usuarioService.listar());
    }

    // Endpoint GET /usuarios/{id}
    // Busca um usuario pelo id.
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> buscarPorId(@PathVariable Long id) {
        UsuarioResponseDTO usuario = usuarioService.buscarPorId(id);

        // Se nao encontrou, responde 404.
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }

        // Se encontrou, responde 200 OK com o usuario no corpo.
        return ResponseEntity.ok(usuario);
    }

    // Endpoint POST /usuarios
    // @Valid faz o Spring validar o DTO antes de chamar o service.
    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> criar(@RequestBody @Valid UsuarioRequestDTO dto) {
        UsuarioResponseDTO usuarioSalvo = usuarioService.criar(dto);

        // Se criou com sucesso, responde 201 CREATED com o usuario salvo.
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
    }

    // Endpoint PUT /usuarios/{id}
    // @Valid faz o Spring validar o DTO antes de atualizar.
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> atualizar(
            @PathVariable Long id,
            @RequestBody @Valid UsuarioRequestDTO dto) {

        UsuarioResponseDTO usuarioAtualizado = usuarioService.atualizar(id, dto);

        // Se nao encontrou, responde 404.
        if (usuarioAtualizado == null) {
            return ResponseEntity.notFound().build();
        }

        // Se atualizou, responde 200 OK com o usuario atualizado.
        return ResponseEntity.ok(usuarioAtualizado);
    }

    // Endpoint DELETE /usuarios/{id}
    // Remove um usuario.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        boolean removido = usuarioService.deletar(id);

        // Se nao encontrou, responde 404.
        if (!removido) {
            return ResponseEntity.notFound().build();
        }

        // Se removeu, responde 204 sem corpo.
        return ResponseEntity.noContent().build();
    }
}
