package br.com.avf.services.usuario.query.repositories;

import br.com.avf.services.usuario.common.models.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-01-28, Friday
 */
@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    @Query("{'$or' : [" +
            "{'nome': {$regex: ?0, $options: '1'}}, " +
            "{'sobrenome': {$regex: ?0, $options: '1'}}, " +
            "{'email': {$regex: ?0, $options: '1'}}, " +
            "{'conta.usuario': {$regex: ?0, $options: '1'}}]}")
    List<Usuario> findByFilterRegex(String filtro);
}
