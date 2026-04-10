package br.com.edbruno.apiusuarios.repository;

// Importa o model Usuario.
// Esse e o objeto que queremos salvar, listar, buscar, atualizar e deletar.
import br.com.edbruno.apiusuarios.model.Usuario;

// Importa o JpaRepository.
// Ele ja traz varios metodos prontos para trabalhar com banco.
import org.springframework.data.jpa.repository.JpaRepository;

// Repository de usuarios.
// Responsabilidade: fazer a ponte entre a aplicacao e o banco de dados.
//
// Usuario = tipo do objeto que sera salvo no banco.
// Long = tipo do id do Usuario.
//
// Como estamos usando JpaRepository, varios metodos ja vem prontos.
// Exemplo: findAll(), findById(), save() e deleteById().
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
