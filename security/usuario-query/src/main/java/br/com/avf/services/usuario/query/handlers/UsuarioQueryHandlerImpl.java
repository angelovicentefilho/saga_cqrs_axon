package br.com.avf.services.usuario.query.handlers;

import br.com.avf.services.usuario.common.models.Usuario;
import br.com.avf.services.usuario.query.protocols.UsuarioQueryResponse;
import br.com.avf.services.usuario.query.queries.ObtemTodosUsuariosQuery;
import br.com.avf.services.usuario.query.queries.ObtemUsuarioPorIdQuery;
import br.com.avf.services.usuario.query.queries.ProcuraUsuariosQuery;
import br.com.avf.services.usuario.query.repositories.UsuarioRepository;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-01-28, Friday
 */
@Service
@RequiredArgsConstructor
public class UsuarioQueryHandlerImpl implements UsuarioQueryHandler {

    private final UsuarioRepository repository;

    @Override
    public UsuarioQueryResponse obtemPorId(ObtemUsuarioPorIdQuery query) {
        Optional<Usuario> usuario = repository.findById(query.getId());
        return usuario.map(UsuarioQueryResponse::new).orElse(null);
    }

    @Override
    public UsuarioQueryResponse procura(ProcuraUsuariosQuery query) {
        List<Usuario> usuarios = Lists.newArrayList(repository.findByFilterRegex(query.getFiltro()));
        return new UsuarioQueryResponse(usuarios);
    }

    @Override
    public UsuarioQueryResponse todos(ObtemTodosUsuariosQuery query) {
        List<Usuario> usuarios = Lists.newArrayList(repository.findAll());
        return new UsuarioQueryResponse(usuarios);
    }
}
