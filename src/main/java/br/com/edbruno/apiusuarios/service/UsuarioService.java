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

        // Copia do DTO para a entidade os campos que queremos salvar.
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());

        // Observacao:
        // embora o DTO receba senha, o fluxo atual ainda nao esta persistindo esse campo.

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

        // Atualiza os campos com os novos valores recebidos.
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());

        // Observacao:
        // a senha ainda nao esta sendo atualizada neste fluxo atual.

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
