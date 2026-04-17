package br.com.edbruno.apiusuarios.service;

// Model que representa o usuario salvo no banco.
import br.com.edbruno.apiusuarios.model.Usuario;

// Repository usado para buscar usuario pelo email.
import br.com.edbruno.apiusuarios.repository.UsuarioRepository;

// Tipos do Spring Security usados para carregar o usuario autenticavel.
import org.springframework.security.core.userdetails.*;

// Marca esta classe como service do Spring.
import org.springframework.stereotype.Service;

// Diz ao Spring: esta classe sabe carregar um usuario para o login.
@Service
public class CustomUserDetailsService implements UserDetailsService {

    // Repository usado para consultar o usuario no banco.
    private final UsuarioRepository usuarioRepository;

    // Construtor usado pelo Spring para entregar o repository pronto.
    public CustomUserDetailsService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Metodo que o Spring Security chama durante a autenticacao.
    // Aqui, o "username" usado no projeto e o email.
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        // Busca o usuario pelo email.
        // Se nao encontrar, lança erro e o login falha.
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado."));

        // Converte o Usuario do sistema para um UserDetails do Spring Security.
        // E esse objeto que o Spring usa para comparar senha e criar a autenticacao.
        return User.builder()
                // Define o email como identificador do login.
                .username(usuario.getEmail())

                // Entrega a senha ja salva no banco.
                .password(usuario.getSenha())

                // Define um papel simples para o usuario autenticado.
                .roles("USER")
                .build();
    }
}
