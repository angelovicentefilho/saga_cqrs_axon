package br.com.avf.services.usuario.query.handlers;

import br.com.avf.services.usuario.common.events.UsuarioAtualizadoEvent;
import br.com.avf.services.usuario.common.events.UsuarioRegistradoEvent;
import br.com.avf.services.usuario.common.events.UsuarioRemovidoEvent;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-01-28, Friday
 */
public interface UsuarioEventHandler {
    void on(UsuarioRegistradoEvent event);
    void on(UsuarioAtualizadoEvent event);
    void on(UsuarioRemovidoEvent event);
}
