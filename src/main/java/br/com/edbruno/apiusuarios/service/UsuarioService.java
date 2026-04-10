package br.com.edbruno.apiusuarios.service;

// Importa o DTO usado para entrada de dados.
import br.com.edbruno.apiusuarios.dto.UsuarioRequestDTO;

// Importa o DTO usado para saida de dados.
import br.com.edbruno.apiusuarios.dto.UsuarioResponseDTO;

// Importa a entidade Usuario, usada internamente no banco.
import br.com.edbruno.apiusuarios.model.Usuario;

// Importa o repository, responsavel por conversar com o banco.
import br.com.edbruno.apiusuarios.repository.UsuarioRepository;

// Diz ao Spring: esta classe e um service.
import org.springframework.stereotype.Service;

// Importa List para trabalhar com listas de usuarios.
import java.util.List;

// Service de usuarios.
// Responsabilidade: aplicar a logica da aplicacao e conversar com o repository.
@Service
public class UsuarioService {

    // Repository usado para salvar, buscar, listar, atualizar e deletar.
    private final UsuarioRepository usuarioRepository;

    // Construtor usado pelo Spring para entregar o repository pronto.
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Lista todos os usuarios do banco.
    // Cada Usuario e convertido para UsuarioResponseDTO.
    public List<UsuarioResponseDTO> listar() {
        return usuarioRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    // Busca um usuario pelo id.
    public UsuarioResponseDTO buscarPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);

        // Se nao encontrar, devolve null.
        // O controller usa isso para responder 404.
        if (usuario == null) {
            return null;
        }

        // Se encontrou, converte a entidade para DTO de resposta.
        return toResponseDTO(usuario);
    }

    // Cria um novo usuario no banco.
    // Recebe um UsuarioRequestDTO vindo do controller.
    public UsuarioResponseDTO criar(UsuarioRequestDTO dto) {

        // Cria a entidade que sera salva no banco.
        Usuario usuario = new Usuario();

        // Copia os dados do DTO para a entidade.
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());

        // Salva no banco.
        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        // Converte para DTO antes de devolver.
        return toResponseDTO(usuarioSalvo);
    }

    // Atualiza um usuario existente.
    // id vem da URL e dto vem do corpo da requisicao.
    public UsuarioResponseDTO atualizar(Long id, UsuarioRequestDTO dto) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);

        // Se nao encontrar, devolve null.
        // O controller usa isso para responder 404.
        if (usuario == null) {
            return null;
        }

        // Atualiza os dados da entidade com os novos valores.
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());

        // Salva as alteracoes no banco.
        Usuario usuarioAtualizado = usuarioRepository.save(usuario);

        // Converte para DTO antes de devolver.
        return toResponseDTO(usuarioAtualizado);
    }

    // Remove um usuario pelo id.
    // Retorna true se removeu e false se nao encontrou.
    public boolean deletar(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);

        // Se nao encontrou, nao ha o que remover.
        if (usuario == null) {
            return false;
        }

        // Remove do banco pelo id.
        usuarioRepository.deleteById(id);
        return true;
    }

    // Metodo auxiliar.
    // Converte a entidade Usuario para UsuarioResponseDTO.
    private UsuarioResponseDTO toResponseDTO(Usuario usuario) {
        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail());
    }
}
