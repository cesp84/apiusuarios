// // package br.com.edbruno.apiusuarios.service;

// // // Importa a classe Usuario, que representa os dados de um usuario.
// // import br.com.edbruno.apiusuarios.model.Usuario;

// // // Importa a anotacao usada para registrar esta classe como service no
// Spring.
// // import org.springframework.stereotype.Service;

// // // Importa uma lista simples que pode crescer conforme adicionamos
// usuarios.
// // import java.util.ArrayList;

// // // Importa o tipo List, usado para representar uma lista de usuarios.
// // import java.util.List;

// // // Diz ao Spring: esta classe e um service.
// // // Service e a camada onde colocamos regras e operacoes do sistema.
// // @Service

// // // Agrupa operacoes relacionadas a usuarios.
// // public class UsuarioService {

// // // Guarda os usuarios temporariamente em memoria.
// // // Por enquanto, os dados somem quando a aplicacao reinicia.
// // private final List<Usuario> usuarios = new ArrayList<>();

// // // Lista todos os usuarios salvos em memoria.
// // public List<Usuario> listar() {
// // return usuarios;
// // }

// // // Recebe um usuario e salva na lista em memoria.
// // public String criar(Usuario usuario) {

// // // Adiciona o usuario recebido na lista.
// // usuarios.add(usuario);

// // // Texto devolvido para indicar sucesso.
// // return "Usuário criado com sucesso";
// // }
// // }
// package br.com.edbruno.apiusuarios.service;

// // Importa o model Usuario, que representa os dados usados neste service.
// import br.com.edbruno.apiusuarios.model.Usuario;

// // Importa a anotacao usada para registrar esta classe como service no
// Spring.
// import org.springframework.stereotype.Service;

// // Importa uma lista simples para guardar usuarios em memoria.
// import java.util.ArrayList;

// // Importa o tipo List, usado para trabalhar com uma lista de usuarios.
// import java.util.List;

// // Diz ao Spring: esta classe e um service.
// // Service e a camada onde colocamos operacoes e regras do sistema.
// @Service

// // Service de usuarios.
// // Responsabilidade: executar as operacoes que envolvem usuarios.
// public class UsuarioService {

// // Guarda os usuarios em memoria.
// // Por enquanto, ao reiniciar a aplicacao, essa lista fica vazia novamente.
// private final List<Usuario> usuarios = new ArrayList<>();

// // Lista todos os usuarios cadastrados.
// public List<Usuario> listar() {
// return usuarios;
// }

// // Busca um usuario pelo id.
// public Usuario buscarPorId(Long id) {

// // Percorre todos os usuarios salvos em memoria.
// for (Usuario usuario : usuarios) {

// // Verifica se o id do usuario atual e igual ao id procurado.
// if (usuario.getId().equals(id)) {

// // Quando encontra, devolve o usuario.
// return usuario;
// }
// }

// // Por enquanto, devolve null se nao encontrar.
// // Depois podemos trocar por uma resposta 404 bem tratada.
// return null;
// }

// // Salva um usuario novo na lista em memoria.
// public String criar(Usuario usuario) {

// // Adiciona o usuario recebido na lista.
// usuarios.add(usuario);

// // Devolve uma mensagem usando o nome enviado no JSON.
// return "Usuário criado com sucesso: " + usuario.getNome();
// }

// // Atualiza nome e email de um usuario existente.
// public String atualizar(Long id, Usuario usuarioAtualizado) {

// // Percorre todos os usuarios procurando o id recebido.
// for (Usuario usuario : usuarios) {

// // Confere se encontrou o usuario certo.
// if (usuario.getId().equals(id)) {

// // Atualiza o nome com o novo valor recebido no JSON.
// usuario.setNome(usuarioAtualizado.getNome());

// // Atualiza o email com o novo valor recebido no JSON.
// usuario.setEmail(usuarioAtualizado.getEmail());

// // Devolve uma mensagem de sucesso.
// return "Usuário " + usuario.getNome() + " atualizado com sucesso";
// }
// }

// // Se terminar o loop sem encontrar, avisa que nao encontrou.
// return "Usuário não encontrado";
// }

// // Remove um usuario pelo id.
// public String deletar(Long id) {

// // Percorre a lista procurando o usuario que sera removido.
// for (Usuario usuario : usuarios) {

// // Confere se o usuario atual tem o id procurado.
// if (usuario.getId().equals(id)) {

// // Remove da lista o usuario encontrado.
// usuarios.remove(usuario);

// // Devolve uma mensagem de sucesso.
// return "Usuário " + usuario.getNome() + " removido com sucesso";
// }
// }

// // Se terminar o loop sem encontrar, avisa que nao encontrou.
// return "Usuário não encontrado";
// }
// }

package br.com.edbruno.apiusuarios.service;

// Importa o model Usuario, que representa os dados da nossa API.
import br.com.edbruno.apiusuarios.model.Usuario;

// Importa o repository, responsavel por conversar com o banco.
import br.com.edbruno.apiusuarios.repository.UsuarioRepository;

// Importa a anotacao usada para registrar esta classe como service no Spring.
import org.springframework.stereotype.Service;

// Importa o tipo List, usado para retornar varios usuarios.
import java.util.List;

// Diz ao Spring: esta classe e um service.
// Service e a camada onde colocamos as operacoes do sistema.
@Service
public class UsuarioService {

    // Repository usado pelo service para acessar a tabela de usuarios.
    private final UsuarioRepository usuarioRepository;

    // Construtor usado pelo Spring para entregar um UsuarioRepository pronto.
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Lista todos os usuarios salvos no banco.
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    // Busca um usuario pelo id.
    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    // Salva um usuario novo no banco.
    public String criar(Usuario usuario) {
        usuarioRepository.save(usuario);
        return "Usuário criado com sucesso: " + usuario.getNome();
    }

    // Atualiza nome e email de um usuario existente.
    public String atualizar(Long id, Usuario usuarioAtualizado) {

        // Procura no banco o usuario que tem o id recebido.
        Usuario usuario = usuarioRepository.findById(id).orElse(null);

        // Se nao encontrou, encerra avisando.
        if (usuario == null) {
            return "Usuário não encontrado";
        }

        // Copia os novos dados recebidos no JSON.
        usuario.setNome(usuarioAtualizado.getNome());
        usuario.setEmail(usuarioAtualizado.getEmail());

        // Salva no banco o usuario atualizado.
        usuarioRepository.save(usuario);

        return "Usuário " + usuario.getNome() + " atualizado com sucesso";
    }

    // Remove um usuario do banco usando o id.
    public String deletar(Long id) {

        // Procura primeiro para saber se o usuario existe e pegar o nome dele.
        Usuario usuario = usuarioRepository.findById(id).orElse(null);

        // Se nao encontrou, encerra avisando.
        if (usuario == null) {
            return "Usuário não encontrado";
        }

        // Deleta no banco pelo id.
        usuarioRepository.deleteById(id);

        return "Usuário " + usuario.getNome() + " removido com sucesso";
    }
}
