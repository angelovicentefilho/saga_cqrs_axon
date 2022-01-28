package br.com.avf.services.usuario.query.handlers;

import br.com.avf.services.usuario.query.protocols.UsuarioQueryResponse;
import br.com.avf.services.usuario.query.queries.ObtemTodosUsuariosQuery;
import br.com.avf.services.usuario.query.queries.ObtemUsuarioPorIdQuery;
import br.com.avf.services.usuario.query.queries.ProcuraUsuariosQuery;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-01-28, Friday
 */
public interface UsuarioQueryHandler {
    UsuarioQueryResponse obtemPorId(ObtemUsuarioPorIdQuery query);
    UsuarioQueryResponse procura(ProcuraUsuariosQuery query);
    UsuarioQueryResponse todos(ObtemTodosUsuariosQuery query);
}
