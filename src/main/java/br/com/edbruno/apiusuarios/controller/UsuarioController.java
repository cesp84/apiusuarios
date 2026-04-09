// package br.com.edbruno.apiusuarios.controller;

// // Importa a classe Usuario, que representa os dados de um usuario.
// import br.com.edbruno.apiusuarios.model.Usuario;

// // Importa a anotacao usada para criar endpoints do tipo GET.
// import org.springframework.web.bind.annotation.GetMapping;

// // Importa a anotacao usada para criar endpoints do tipo POST.
// import org.springframework.web.bind.annotation.PostMapping;

// // Importa a anotacao usada para definir o caminho principal deste controller.
// import org.springframework.web.bind.annotation.RequestMapping;

// // Importa a anotacao usada para receber dados enviados no corpo da requisicao.
// import org.springframework.web.bind.annotation.RequestBody;

// // Importa a anotacao usada para criar um controller REST.
// import org.springframework.web.bind.annotation.RestController;

// // Importa uma lista simples que pode crescer conforme adicionamos usuarios.
// import java.util.ArrayList;

// // Importa o tipo List, usado para representar uma lista de usuarios.
// import java.util.List;

// // Diz ao Spring: esta classe responde requisicoes HTTP.
// @RestController
// // Diz ao Spring: todos os endpoints desta classe comecam com /usuarios.
// @RequestMapping("/usuarios")
// // Agrupa os endpoints relacionados a usuarios.
// public class UsuarioController {

//     // Guarda os usuarios temporariamente em memoria.
//     // Por enquanto, os dados somem quando a aplicacao reinicia.
//     private final List<Usuario> usuarios = new ArrayList<>();

//     // Diz ao Spring: quando alguem acessar GET /usuarios, execute este metodo.
//     @GetMapping
//     // Este metodo retorna a lista atual de usuarios.
//     public List<Usuario> listar() {
//         // Envia a lista de usuarios como resposta.
//         return usuarios;
//     }

//     // Diz ao Spring: quando alguem acessar POST /usuarios, execute este metodo.
//     @PostMapping
//     // Este metodo recebe um usuario do corpo da requisicao e salva na lista.
//     public String criar(@RequestBody Usuario usuario) {
//         // Adiciona o usuario recebido na lista em memoria.
//         usuarios.add(usuario);

//         // Texto enviado como resposta depois de cadastrar.
//         return "Usuário criado com sucesso";
//     }
// }

package br.com.edbruno.apiusuarios.controller;

// Importa a classe Usuario, que representa os dados de um usuario.
import br.com.edbruno.apiusuarios.model.Usuario;

// Importa a anotacao usada para criar endpoints do tipo DELETE.
import org.springframework.web.bind.annotation.DeleteMapping;

// Importa a anotacao usada para criar endpoints do tipo GET.
import org.springframework.web.bind.annotation.GetMapping;

// Importa a anotacao usada para pegar valores que vem na URL, como /usuarios/1.
import org.springframework.web.bind.annotation.PathVariable;

// Importa a anotacao usada para criar endpoints do tipo POST.
import org.springframework.web.bind.annotation.PostMapping;

// Importa a anotacao usada para criar endpoints do tipo PUT.
import org.springframework.web.bind.annotation.PutMapping;

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

    // Este metodo retorna todos os usuarios cadastrados na lista.
    public List<Usuario> listar() {
        return usuarios;
    }

    // Diz ao Spring: quando alguem acessar GET /usuarios/{id}, execute este metodo.
    @GetMapping("/{id}")

    // Este metodo busca um usuario pelo id recebido na URL.
    public Usuario buscarPorId(@PathVariable Long id) {

        // Percorre a lista procurando usuario por usuario.
        for (Usuario usuario : usuarios) {

            // Compara o id do usuario da lista com o id recebido na URL.
            if (usuario.getId().equals(id)) {

                // Se encontrar, devolve o usuario como resposta.
                return usuario;
            }
        }

        // Por enquanto, se nao encontrar, devolve null.
        // Mais para frente vamos tratar isso com resposta HTTP adequada.
        return null;
    }

    // Diz ao Spring: quando alguem acessar POST /usuarios, execute este metodo.
    @PostMapping

    // Este metodo recebe um usuario em JSON e salva na lista em memoria.
    public String criar(@RequestBody Usuario usuario) {
        usuarios.add(usuario);
        return "Usuário criado com sucesso";
    }

    // Diz ao Spring: quando alguem acessar PUT /usuarios/{id}, execute este metodo.
    @PutMapping("/{id}")

    // Este metodo atualiza nome e email de um usuario existente.
    public String atualizar(@PathVariable Long id, @RequestBody Usuario usuarioAtualizado) {

        // Percorre a lista procurando o usuario que sera atualizado.
        for (Usuario usuario : usuarios) {

            // Confere se o id do usuario atual e igual ao id recebido na URL.
            if (usuario.getId().equals(id)) {

                // Copia o novo nome recebido no JSON para o usuario salvo na lista.
                usuario.setNome(usuarioAtualizado.getNome());

                // Copia o novo email recebido no JSON para o usuario salvo na lista.
                usuario.setEmail(usuarioAtualizado.getEmail());

                // Encerra o metodo avisando que a atualizacao funcionou.
                return "Usuário atualizado com sucesso";
            }
        }

        return "Usuário não encontrado";
    }

    // Diz ao Spring: quando alguem acessar DELETE /usuarios/{id}, execute este
    // metodo.
    @DeleteMapping("/{id}")

    // Este metodo remove um usuario pelo id recebido na URL.
    public String deletar(@PathVariable Long id) {

        // Percorre a lista procurando o usuario que sera removido.
        for (Usuario usuario : usuarios) {

            // Confere se encontrou o usuario com o id recebido na URL.
            if (usuario.getId().equals(id)) {

                // Remove o usuario encontrado da lista em memoria.
                usuarios.remove(usuario);

                // Encerra o metodo avisando que a remocao funcionou.
                return "Usuário removido com sucesso";
            }
        }

        return "Usuário não encontrado";
    }

}
