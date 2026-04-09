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

// package br.com.edbruno.apiusuarios.service;

// // Importa o model Usuario, que representa os dados da nossa API.
// import br.com.edbruno.apiusuarios.model.Usuario;

// // Importa o repository, responsavel por conversar com o banco.
// import br.com.edbruno.apiusuarios.repository.UsuarioRepository;

// // Importa a anotacao usada para registrar esta classe como service no Spring.
// import org.springframework.stereotype.Service;

// // Importa o tipo List, usado para retornar varios usuarios.
// import java.util.List;

// // Diz ao Spring: esta classe e um service.
// // Service e a camada onde colocamos as operacoes do sistema.
// @Service
// public class UsuarioService {

//     // Repository usado pelo service para acessar a tabela de usuarios.
//     private final UsuarioRepository usuarioRepository;

//     // Construtor usado pelo Spring para entregar um UsuarioRepository pronto.
//     public UsuarioService(UsuarioRepository usuarioRepository) {
//         this.usuarioRepository = usuarioRepository;
//     }

//     // Lista todos os usuarios salvos no banco.
//     public List<Usuario> listar() {
//         return usuarioRepository.findAll();
//     }

//     // Busca um usuario pelo id.
//     public Usuario buscarPorId(Long id) {
//         return usuarioRepository.findById(id).orElse(null);
//     }

//     // Salva um usuario novo no banco.
//     public String criar(Usuario usuario) {
//         usuarioRepository.save(usuario);
//         return "Usuário criado com sucesso: " + usuario.getNome();
//     }

//     // Atualiza nome e email de um usuario existente.
//     public String atualizar(Long id, Usuario usuarioAtualizado) {

//         // Procura no banco o usuario que tem o id recebido.
//         Usuario usuario = usuarioRepository.findById(id).orElse(null);

//         // Se nao encontrou, encerra avisando.
//         if (usuario == null) {
//             return "Usuário não encontrado";
//         }

//         // Copia os novos dados recebidos no JSON.
//         usuario.setNome(usuarioAtualizado.getNome());
//         usuario.setEmail(usuarioAtualizado.getEmail());

//         // Salva no banco o usuario atualizado.
//         usuarioRepository.save(usuario);

//         return "Usuário " + usuario.getNome() + " atualizado com sucesso";
//     }

//     // Remove um usuario do banco usando o id.
//     public String deletar(Long id) {

//         // Procura primeiro para saber se o usuario existe e pegar o nome dele.
//         Usuario usuario = usuarioRepository.findById(id).orElse(null);

//         // Se nao encontrou, encerra avisando.
//         if (usuario == null) {
//             return "Usuário não encontrado";
//         }

//         // Deleta no banco pelo id.
//         usuarioRepository.deleteById(id);

//         return "Usuário " + usuario.getNome() + " removido com sucesso";
//     }
// }
// package br.com.edbruno.apiusuarios.service;

// // Importa o model Usuario, que representa os dados da nossa API.
// import br.com.edbruno.apiusuarios.model.Usuario;

// // Importa o repository, responsavel por conversar com o banco.
// import br.com.edbruno.apiusuarios.repository.UsuarioRepository;

// // Importa a anotacao usada para registrar esta classe como service no Spring.
// import org.springframework.stereotype.Service;

// // Importa List, usado quando precisamos retornar varios usuarios.
// import java.util.List;

// // Diz ao Spring: esta classe e um service.
// // Service guarda as operacoes do sistema.
// @Service
// public class UsuarioService {

//     // Repository usado para salvar, buscar, listar e deletar usuarios no banco.
//     private final UsuarioRepository usuarioRepository;

//     // Construtor usado pelo Spring para entregar um UsuarioRepository pronto.
//     public UsuarioService(UsuarioRepository usuarioRepository) {
//         this.usuarioRepository = usuarioRepository;
//     }

//     // Busca todos os usuarios no banco.
//     public List<Usuario> listar() {
//         return usuarioRepository.findAll();
//     }

//     // Busca um usuario pelo id.
//     public Usuario buscarPorId(Long id) {

//         // findById procura no banco.
//         // orElse(null) devolve null quando nao encontra.
//         return usuarioRepository.findById(id).orElse(null);
//     }

//     // Cria um usuario novo.
//     // Recebe o objeto Usuario que veio do controller.
//     public Usuario criar(Usuario usuario) {

//         // save salva no banco e devolve o usuario salvo.
//         // Depois de salvar, o usuario ja pode vir com id gerado pelo banco.
//         return usuarioRepository.save(usuario);
//     }

//     // Atualiza um usuario existente.
//     // id vem da URL, usuarioAtualizado vem do JSON/body.
//     public Usuario atualizar(Long id, Usuario usuarioAtualizado) {

//         // Primeiro procura o usuario atual no banco.
//         Usuario usuario = usuarioRepository.findById(id).orElse(null);

//         // Se nao encontrar, devolve null.
//         // O controller usa esse null para responder 404.
//         if (usuario == null) {
//             return null;
//         }

//         // Copia os dados novos para o usuario encontrado no banco.
//         usuario.setNome(usuarioAtualizado.getNome());
//         usuario.setEmail(usuarioAtualizado.getEmail());

//         // Salva as alteracoes e devolve o usuario atualizado.
//         return usuarioRepository.save(usuario);
//     }

//     // Deleta um usuario pelo id.
//     // Retorna true se deletou, false se nao encontrou.
//     public boolean deletar(Long id) {

//         // Procura antes de deletar.
//         // Assim sabemos se o id existe.
//         Usuario usuario = usuarioRepository.findById(id).orElse(null);

//         // Se nao encontrou, avisa que nao deletou.
//         if (usuario == null) {
//             return false;
//         }

//         // Remove do banco pelo id.
//         usuarioRepository.deleteById(id);

//         // Avisa que a remocao funcionou.
//         return true;
//     }
// }

package br.com.edbruno.apiusuarios.service;

// Importa o DTO usado para entrada de dados.
import br.com.edbruno.apiusuarios.dto.UsuarioRequestDTO;

// Importa o DTO usado para saida de dados.
import br.com.edbruno.apiusuarios.dto.UsuarioResponseDTO;

// Importa a entidade Usuario, usada internamente para salvar no banco.
import br.com.edbruno.apiusuarios.model.Usuario;

// Importa o repository, que conversa com o banco.
import br.com.edbruno.apiusuarios.repository.UsuarioRepository;

// Diz ao Spring: esta classe e um service.
import org.springframework.stereotype.Service;

// Importa List para devolver varios usuarios.
import java.util.List;

// Service de usuarios.
// Responsabilidade: receber dados do controller, trabalhar com a entidade e devolver DTOs.
@Service
public class UsuarioService {

    // Repository usado para acessar o banco.
    private final UsuarioRepository usuarioRepository;

    // Construtor usado pelo Spring para entregar o repository pronto.
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Lista todos os usuarios do banco e converte cada Usuario para UsuarioResponseDTO.
    public List<UsuarioResponseDTO> listar() {
        return usuarioRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    // Busca um usuario pelo id e devolve o DTO de resposta.
    public UsuarioResponseDTO buscarPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);

        // Se nao encontrou, devolve null.
        // O controller usa isso para responder 404.
        if (usuario == null) {
            return null;
        }

        return toResponseDTO(usuario);
    }

    // Cria um usuario novo a partir do DTO recebido.
    public UsuarioResponseDTO criar(UsuarioRequestDTO dto) {

        // Cria a entidade que sera salva no banco.
        Usuario usuario = new Usuario();

        // Copia do DTO para a entidade apenas os campos existentes no model.
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());

        // Observacao importante:
        // dto.getSenha() existe no request, mas ainda nao existe no model Usuario.
        // Isso significa que a senha NAO esta sendo salva neste momento.

        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        // Converte a entidade salva para DTO de resposta.
        return toResponseDTO(usuarioSalvo);
    }

    // Atualiza um usuario existente usando os dados do DTO.
    public UsuarioResponseDTO atualizar(Long id, UsuarioRequestDTO dto) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);

        // Se nao encontrou, devolve null para o controller responder 404.
        if (usuario == null) {
            return null;
        }

        // Atualiza apenas os campos existentes no model.
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());

        // Observacao importante:
        // a senha ainda nao esta sendo salva porque o model Usuario nao tem campo senha.

        Usuario usuarioAtualizado = usuarioRepository.save(usuario);

        return toResponseDTO(usuarioAtualizado);
    }

    // Deleta um usuario pelo id.
    // Retorna true quando remove e false quando nao encontra.
    public boolean deletar(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);

        if (usuario == null) {
            return false;
        }

        usuarioRepository.deleteById(id);
        return true;
    }

    // Metodo auxiliar.
    // Converte a entidade Usuario para o DTO de resposta.
    private UsuarioResponseDTO toResponseDTO(Usuario usuario) {
        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail());
    }
}
