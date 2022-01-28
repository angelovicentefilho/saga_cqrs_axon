package br.com.avf.services.usuario.oauth.repositories;

import br.com.avf.services.usuario.common.models.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-01-28, Friday
 */
public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    @Query("{'conta.usuario': ?0}")
    Optional<Usuario> findByUsuario(String usuario);
}
