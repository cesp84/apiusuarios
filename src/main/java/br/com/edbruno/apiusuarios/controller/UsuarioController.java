package br.com.edbruno.apiusuarios.controller;

// Importa a classe Usuario, que representa os dados de um usuario.
import br.com.edbruno.apiusuarios.model.Usuario;

// Importa a anotacao usada para criar endpoints do tipo GET.
import org.springframework.web.bind.annotation.GetMapping;

// Importa a anotacao usada para criar endpoints do tipo POST.
import org.springframework.web.bind.annotation.PostMapping;

// Importa a anotacao usada para definir o caminho principal deste controller.
import org.springframework.web.bind.annotation.RequestMapping;

// Importa a anotacao usada para receber dados enviados no corpo da requisicao.
import org.springframework.web.bind.annotation.RequestBody;

// Importa a anotacao usada para criar um controller REST.
import org.springframework.web.bind.annotation.RestController;

// Importa uma lista simples que pode crescer conforme adicionamos usuarios.
import java.util.ArrayList;

// Importa o tipo List, usado para representar uma lista de usuarios.
import java.util.List;

// Diz ao Spring: esta classe responde requisicoes HTTP.
@RestController
// Diz ao Spring: todos os endpoints desta classe comecam com /usuarios.
@RequestMapping("/usuarios")
// Agrupa os endpoints relacionados a usuarios.
public class UsuarioController {

    // Guarda os usuarios temporariamente em memoria.
    // Por enquanto, os dados somem quando a aplicacao reinicia.
    private final List<Usuario> usuarios = new ArrayList<>();

    // Diz ao Spring: quando alguem acessar GET /usuarios, execute este metodo.
    @GetMapping
    // Este metodo retorna a lista atual de usuarios.
    public List<Usuario> listar() {
        // Envia a lista de usuarios como resposta.
        return usuarios;
    }

    // Diz ao Spring: quando alguem acessar POST /usuarios, execute este metodo.
    @PostMapping
    // Este metodo recebe um usuario do corpo da requisicao e salva na lista.
    public String criar(@RequestBody Usuario usuario) {
        // Adiciona o usuario recebido na lista em memoria.
        usuarios.add(usuario);

        // Texto enviado como resposta depois de cadastrar.
        return "Usuário criado com sucesso";
    }
}
