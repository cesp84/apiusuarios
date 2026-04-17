package br.com.edbruno.apiusuarios.service;

// DTO de entrada usado no cadastro e atualização.
import br.com.edbruno.apiusuarios.dto.UsuarioRequestDTO;

// DTO de saída devolvido para a API.
import br.com.edbruno.apiusuarios.dto.UsuarioResponseDTO;

// Model interno que representa o usuário.
import br.com.edbruno.apiusuarios.model.Usuario;

// Repository usado para falar com o banco.
import br.com.edbruno.apiusuarios.repository.UsuarioRepository;

// Componente usado para criptografar a senha.
import org.springframework.security.crypto.password.PasswordEncoder;

// Marca esta classe como service do Spring.
import org.springframework.stereotype.Service;

// Tipo de lista usado na resposta de listagem.
import java.util.List;

// Diz ao Spring: esta classe cuida das regras de usuários.
@Service
public class UsuarioService {

    // Repository usado para salvar, buscar, atualizar e deletar no banco.
    private final UsuarioRepository usuarioRepository;

    // Encoder usado para nunca salvar a senha em texto puro.
    private final PasswordEncoder passwordEncoder;

    // Construtor usado pelo Spring para entregar as dependências prontas.
    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Lista todos os usuários do banco.
    // Depois converte cada Usuario para UsuarioResponseDTO.
    public List<UsuarioResponseDTO> listar() {
        return usuarioRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    // Busca um usuário pelo id.
    // Se não encontrar, devolve null.
    public UsuarioResponseDTO buscarPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);

        if (usuario == null) {
            return null;
        }

        return toResponseDTO(usuario);
    }

    // Cria um novo usuário.
    // Antes de salvar, valida se o email já existe.
    public UsuarioResponseDTO criar(UsuarioRequestDTO dto) {
        if (usuarioRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Já existe usuário cadastrado com este email.");
        }

        // Monta o objeto Usuario com os dados recebidos.
        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());

        // Criptografa a senha antes de salvar no banco.
        usuario.setSenha(passwordEncoder.encode(dto.getSenha()));

        // Salva no banco e devolve no formato de resposta da API.
        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        return toResponseDTO(usuarioSalvo);
    }

    // Atualiza um usuário existente.
    // Se não encontrar o id, devolve null.
    public UsuarioResponseDTO atualizar(Long id, UsuarioRequestDTO dto) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);

        if (usuario == null) {
            return null;
        }

        // Só valida email duplicado se o email novo for diferente do atual.
        if (!usuario.getEmail().equals(dto.getEmail()) &&
                usuarioRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Já existe usuário cadastrado com este email.");
        }

        // Atualiza os dados do usuário encontrado.
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());

        // Criptografa a nova senha antes de salvar.
        usuario.setSenha(passwordEncoder.encode(dto.getSenha()));

        // Salva as alterações no banco e devolve a resposta pronta.
        Usuario usuarioAtualizado = usuarioRepository.save(usuario);
        return toResponseDTO(usuarioAtualizado);
    }

    // Deleta um usuário pelo id.
    // Devolve true se apagou e false se não encontrou.
    public boolean deletar(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);

        if (usuario == null) {
            return false;
        }

        usuarioRepository.deleteById(id);
        return true;
    }

    // Converte o model Usuario para o DTO de saída.
    // Aqui escolhemos o que a API vai mostrar na resposta.
    private UsuarioResponseDTO toResponseDTO(Usuario usuario) {
        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail());
    }
}
