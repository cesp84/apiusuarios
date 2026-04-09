// package br.com.edbruno.apiusuarios.controller;

// // Importa a classe Usuario, que representa os dados de um usuario.
// import br.com.edbruno.apiusuarios.model.Usuario;

// // Importa a anotacao usada para criar endpoints do tipo GET.
// import org.springframework.web.bind.annotation.GetMapping;

// // Importa a anotacao usada para criar endpoints do tipo POST.
// import org.springframework.web.bind.annotation.PostMapping;

// // Importa a anotacao usada para definir o caminho principal deste
// controller.
// import org.springframework.web.bind.annotation.RequestMapping;

// // Importa a anotacao usada para receber dados enviados no corpo da
// requisicao.
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

// // Guarda os usuarios temporariamente em memoria.
// // Por enquanto, os dados somem quando a aplicacao reinicia.
// private final List<Usuario> usuarios = new ArrayList<>();

// // Diz ao Spring: quando alguem acessar GET /usuarios, execute este metodo.
// @GetMapping
// // Este metodo retorna a lista atual de usuarios.
// public List<Usuario> listar() {
// // Envia a lista de usuarios como resposta.
// return usuarios;
// }

// // Diz ao Spring: quando alguem acessar POST /usuarios, execute este metodo.
// @PostMapping
// // Este metodo recebe um usuario do corpo da requisicao e salva na lista.
// public String criar(@RequestBody Usuario usuario) {
// // Adiciona o usuario recebido na lista em memoria.
// usuarios.add(usuario);

// // Texto enviado como resposta depois de cadastrar.
// return "Usuário criado com sucesso";
// }
// }

// package br.com.edbruno.apiusuarios.controller;

// // Importa a classe Usuario, que representa os dados de um usuario.
// import br.com.edbruno.apiusuarios.model.Usuario;

// // Importa a anotacao usada para criar endpoints do tipo DELETE.
// import org.springframework.web.bind.annotation.DeleteMapping;

// // Importa a anotacao usada para criar endpoints do tipo GET.
// import org.springframework.web.bind.annotation.GetMapping;

// // Importa a anotacao usada para pegar valores que vem na URL, como
// /usuarios/1.
// import org.springframework.web.bind.annotation.PathVariable;

// // Importa a anotacao usada para criar endpoints do tipo POST.
// import org.springframework.web.bind.annotation.PostMapping;

// // Importa a anotacao usada para criar endpoints do tipo PUT.
// import org.springframework.web.bind.annotation.PutMapping;

// // Importa a anotacao usada para definir o caminho principal deste
// controller.
// import org.springframework.web.bind.annotation.RequestMapping;

// // Importa a anotacao usada para receber dados enviados no corpo da
// requisicao.
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

// // Guarda os usuarios temporariamente em memoria.
// // Por enquanto, os dados somem quando a aplicacao reinicia.
// private final List<Usuario> usuarios = new ArrayList<>();

// // Diz ao Spring: quando alguem acessar GET /usuarios, execute este metodo.
// @GetMapping

// // Este metodo retorna todos os usuarios cadastrados na lista.
// public List<Usuario> listar() {
// return usuarios;
// }

// // Diz ao Spring: quando alguem acessar GET /usuarios/{id}, execute este
// metodo.
// @GetMapping("/{id}")

// // Este metodo busca um usuario pelo id recebido na URL.
// public Usuario buscarPorId(@PathVariable Long id) {

// // Percorre a lista procurando usuario por usuario.
// for (Usuario usuario : usuarios) {

// // Compara o id do usuario da lista com o id recebido na URL.
// if (usuario.getId().equals(id)) {

// // Se encontrar, devolve o usuario como resposta.
// return usuario;
// }
// }

// // Por enquanto, se nao encontrar, devolve null.
// // Mais para frente vamos tratar isso com resposta HTTP adequada.
// return null;
// }

// // Diz ao Spring: quando alguem acessar POST /usuarios, execute este metodo.
// @PostMapping

// // Este metodo recebe um usuario em JSON e salva na lista em memoria.
// public String criar(@RequestBody Usuario usuario) {
// usuarios.add(usuario);
// return "Usuário criado com sucesso: " + usuario.getNome();
// }

// // Diz ao Spring: quando alguem acessar PUT /usuarios/{id}, execute este
// metodo.
// @PutMapping("/{id}")

// // Este metodo atualiza nome e email de um usuario existente.
// public String atualizar(@PathVariable Long id, @RequestBody Usuario
// usuarioAtualizado) {

// // Percorre a lista procurando o usuario que sera atualizado.
// for (Usuario usuario : usuarios) {

// // Confere se o id do usuario atual e igual ao id recebido na URL.
// if (usuario.getId().equals(id)) {

// // Copia o novo nome recebido no JSON para o usuario salvo na lista.
// usuario.setNome(usuarioAtualizado.getNome());

// // Copia o novo email recebido no JSON para o usuario salvo na lista.
// usuario.setEmail(usuarioAtualizado.getEmail());

// // Encerra o metodo avisando que a atualizacao funcionou.
// return "Usuário " + usuario.getNome() + " atualizado com sucesso";
// }
// }

// return "Usuário não encontrado";
// }

// // Diz ao Spring: quando alguem acessar DELETE /usuarios/{id}, execute este
// // metodo.
// @DeleteMapping("/{id}")

// // Este metodo remove um usuario pelo id recebido na URL.
// public String deletar(@PathVariable Long id) {

// // Percorre a lista procurando o usuario que sera removido.
// for (Usuario usuario : usuarios) {

// // Confere se encontrou o usuario com o id recebido na URL.
// if (usuario.getId().equals(id)) {

// // Remove o usuario encontrado da lista em memoria.
// usuarios.remove(usuario);

// // Encerra o metodo avisando que a remocao funcionou.
// return "Usuário " + usuario.getNome() + " removido com sucesso";
// }
// }

// return "Usuário não encontrado";
// }

// }

// package br.com.edbruno.apiusuarios.controller;

// // Importa o model Usuario, usado no tipo de retorno e no corpo das
// requisicoes.
// import br.com.edbruno.apiusuarios.model.Usuario;

// // Importa o service que guarda a regra/operacoes de usuarios.
// import br.com.edbruno.apiusuarios.service.UsuarioService;

// // Importa a anotacao usada para criar endpoints do tipo DELETE.
// import org.springframework.web.bind.annotation.DeleteMapping;

// // Importa a anotacao usada para criar endpoints do tipo GET.
// import org.springframework.web.bind.annotation.GetMapping;

// // Importa a anotacao usada para pegar valores da URL, como o id em
// /usuarios/1.
// import org.springframework.web.bind.annotation.PathVariable;

// // Importa a anotacao usada para criar endpoints do tipo POST.
// import org.springframework.web.bind.annotation.PostMapping;

// // Importa a anotacao usada para criar endpoints do tipo PUT.
// import org.springframework.web.bind.annotation.PutMapping;

// // Importa a anotacao usada para definir a rota principal do controller.
// import org.springframework.web.bind.annotation.RequestMapping;

// // Importa a anotacao usada para ler o JSON enviado no corpo da requisicao.
// import org.springframework.web.bind.annotation.RequestBody;

// // Importa a anotacao usada para criar um controller REST.
// import org.springframework.web.bind.annotation.RestController;

// // Importa o tipo List, usado para devolver varios usuarios.
// import java.util.List;

// // Diz ao Spring: esta classe recebe requisicoes HTTP e devolve respostas da
// API.
// @RestController

// // Diz ao Spring: todas as rotas desta classe comecam com /usuarios.
// @RequestMapping("/usuarios")

// // Controller de usuarios.
// // Responsabilidade: receber a requisicao e chamar o UsuarioService.
// public class UsuarioController {

// // Service que contem as operacoes de usuarios.
// private final UsuarioService usuarioService;

// // Construtor usado pelo Spring para entregar um UsuarioService pronto.
// public UsuarioController(UsuarioService usuarioService) {

// // Guarda o service recebido para os metodos deste controller usarem.
// this.usuarioService = usuarioService;
// }

// // Diz ao Spring: quando alguem acessar GET /usuarios, execute este metodo.
// @GetMapping

// // Lista usuarios chamando o service.
// public List<Usuario> listar() {
// return usuarioService.listar();
// }

// // Diz ao Spring: quando alguem acessar GET /usuarios/{id}, execute este
// metodo.
// @GetMapping("/{id}")

// // Busca um usuario pelo id recebido na URL.
// public Usuario buscarPorId(@PathVariable Long id) {
// return usuarioService.buscarPorId(id);
// }

// // Diz ao Spring: quando alguem acessar POST /usuarios, execute este metodo.
// @PostMapping

// // Recebe um usuario em JSON e pede para o service cadastrar.
// public String criar(@RequestBody Usuario usuario) {
// return usuarioService.criar(usuario);
// }

// // Diz ao Spring: quando alguem acessar PUT /usuarios/{id}, execute este
// metodo.
// @PutMapping("/{id}")

// // Recebe o id pela URL, recebe os novos dados pelo JSON e pede para o
// service atualizar.
// public String atualizar(@PathVariable Long id, @RequestBody Usuario
// usuarioAtualizado) {
// return usuarioService.atualizar(id, usuarioAtualizado);
// }

// // Diz ao Spring: quando alguem acessar DELETE /usuarios/{id}, execute este
// metodo.
// @DeleteMapping("/{id}")

// // Recebe o id pela URL e pede para o service deletar.
// public String deletar(@PathVariable Long id) {
// return usuarioService.deletar(id);
// }
// }

// package br.com.edbruno.apiusuarios.controller;

// // Importa o model Usuario, usado para receber/enviar dados de usuario.
// import br.com.edbruno.apiusuarios.model.Usuario;

// // Importa o service, onde ficam as operacoes de usuario.
// import br.com.edbruno.apiusuarios.service.UsuarioService;

// // Importa as anotacoes REST do Spring.
// import org.springframework.web.bind.annotation.*;

// // Importa List, usado para retornar varios usuarios.
// import java.util.List;

// // Diz ao Spring: esta classe responde requisicoes HTTP e devolve dados.
// @RestController

// // Diz ao Spring: todas as rotas deste controller comecam com /usuarios.
// @RequestMapping("/usuarios")
// public class UsuarioController {

//     // Service usado pelo controller.
//     // O controller recebe a requisicao e passa o trabalho para o service.
//     private final UsuarioService usuarioService;

//     // Construtor usado pelo Spring para entregar o UsuarioService pronto.
//     public UsuarioController(UsuarioService usuarioService) {
//         this.usuarioService = usuarioService;
//     }

//     // Endpoint GET /usuarios
//     // Lista todos os usuarios.
//     @GetMapping
//     public List<Usuario> listar() {
//         return usuarioService.listar();
//     }

//     // Endpoint GET /usuarios/{id}
//     // Busca um usuario pelo id que veio na URL.
//     @GetMapping("/{id}")
//     public Usuario buscarPorId(@PathVariable Long id) {
//         return usuarioService.buscarPorId(id);
//     }

//     // Endpoint POST /usuarios
//     // Recebe um JSON no body e cria um usuario.
//     @PostMapping
//     public String criar(@RequestBody Usuario usuario) {
//         return usuarioService.criar(usuario);
//     }

//     // Endpoint PUT /usuarios/{id}
//     // Recebe o id pela URL e os dados novos pelo body.
//     @PutMapping("/{id}")
//     public String atualizar(@PathVariable Long id, @RequestBody Usuario usuarioAtualizado) {
//         return usuarioService.atualizar(id, usuarioAtualizado);
//     }

//     // Endpoint DELETE /usuarios/{id}
//     // Remove um usuario pelo id.
//     @DeleteMapping("/{id}")
//     public String deletar(@PathVariable Long id) {
//         return usuarioService.deletar(id);
//     }
// }

package br.com.edbruno.apiusuarios.controller;

// Importa o model Usuario, usado no corpo das respostas e requisicoes.
import br.com.edbruno.apiusuarios.model.Usuario;

// Importa o service, que executa as operacoes de usuarios.
import br.com.edbruno.apiusuarios.service.UsuarioService;

// Importa status HTTP, como 201 CREATED.
import org.springframework.http.HttpStatus;

// ResponseEntity permite devolver corpo + status HTTP.
// Exemplo: 200 OK, 201 CREATED, 404 NOT FOUND.
import org.springframework.http.ResponseEntity;

// Importa as anotacoes REST do Spring.
import org.springframework.web.bind.annotation.*;

// Importa List, usado para devolver varios usuarios.
import java.util.List;

// Diz ao Spring: esta classe recebe requisicoes HTTP e devolve respostas REST.
@RestController

// Diz ao Spring: todas as rotas desta classe comecam com /usuarios.
@RequestMapping("/usuarios")
public class UsuarioController {

    // Service usado pelo controller.
    // O controller recebe HTTP; o service executa a operacao.
    private final UsuarioService usuarioService;

    // Construtor usado pelo Spring para entregar o UsuarioService pronto.
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // Endpoint GET /usuarios
    // ResponseEntity<List<Usuario>> significa: resposta HTTP com uma lista no corpo.
    @GetMapping
    public ResponseEntity<List<Usuario>> listar() {

        // Pede ao service todos os usuarios.
        List<Usuario> usuarios = usuarioService.listar();

        // Devolve 200 OK com a lista de usuarios no corpo da resposta.
        return ResponseEntity.ok(usuarios);
    }

    // Endpoint GET /usuarios/{id}
    // Busca um usuario especifico.
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id) {

        // Pede ao service para buscar pelo id recebido na URL.
        Usuario usuario = usuarioService.buscarPorId(id);

        // Se nao encontrou, responde 404 NOT FOUND.
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }

        // Se encontrou, responde 200 OK com o usuario no corpo.
        return ResponseEntity.ok(usuario);
    }

    // Endpoint POST /usuarios
    // Cria um usuario novo com o JSON enviado no body.
    @PostMapping
    public ResponseEntity<Usuario> criar(@RequestBody Usuario usuario) {

        // Pede ao service para salvar o usuario.
        Usuario usuarioSalvo = usuarioService.criar(usuario);

        // Responde 201 CREATED com o usuario salvo no corpo.
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
    }

    // Endpoint PUT /usuarios/{id}
    // Atualiza um usuario existente.
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @RequestBody Usuario usuarioAtualizado) {

        // Pede ao service para atualizar.
        Usuario usuario = usuarioService.atualizar(id, usuarioAtualizado);

        // Se o service devolveu null, o usuario nao foi encontrado.
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }

        // Responde 200 OK com o usuario atualizado no corpo.
        return ResponseEntity.ok(usuario);
    }

    // Endpoint DELETE /usuarios/{id}
    // Remove um usuario.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {

        // Pede ao service para remover.
        // true = removeu, false = nao encontrou.
        boolean removido = usuarioService.deletar(id);

        // Se nao removeu, responde 404 NOT FOUND.
        if (!removido) {
            return ResponseEntity.notFound().build();
        }

        // Se removeu, responde 204 NO CONTENT.
        // Significa: deu certo, mas nao vou devolver corpo.
        return ResponseEntity.noContent().build();
    }
}
