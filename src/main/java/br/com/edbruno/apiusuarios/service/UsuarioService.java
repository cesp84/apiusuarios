package br.com.edbruno.apiusuarios.service;

// Importa a classe Usuario, que representa os dados de um usuario.
import br.com.edbruno.apiusuarios.model.Usuario;

// Importa a anotacao usada para registrar esta classe como service no Spring.
import org.springframework.stereotype.Service;

// Importa uma lista simples que pode crescer conforme adicionamos usuarios.
import java.util.ArrayList;

// Importa o tipo List, usado para representar uma lista de usuarios.
import java.util.List;

// Diz ao Spring: esta classe e um service.
// Service e a camada onde colocamos regras e operacoes do sistema.
@Service

// Agrupa operacoes relacionadas a usuarios.
public class UsuarioService {

    // Guarda os usuarios temporariamente em memoria.
    // Por enquanto, os dados somem quando a aplicacao reinicia.
    private final List<Usuario> usuarios = new ArrayList<>();

    // Lista todos os usuarios salvos em memoria.
    public List<Usuario> listar() {
        return usuarios;
    }

    // Recebe um usuario e salva na lista em memoria.
    public String criar(Usuario usuario) {

        // Adiciona o usuario recebido na lista.
        usuarios.add(usuario);

        // Texto devolvido para indicar sucesso.
        return "Usuário criado com sucesso";
    }
}
