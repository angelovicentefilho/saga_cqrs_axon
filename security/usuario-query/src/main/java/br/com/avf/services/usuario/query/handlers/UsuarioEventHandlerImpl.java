package br.com.avf.services.usuario.query.handlers;

import br.com.avf.services.usuario.common.events.UsuarioAtualizadoEvent;
import br.com.avf.services.usuario.common.events.UsuarioRegistradoEvent;
import br.com.avf.services.usuario.common.events.UsuarioRemovidoEvent;
import br.com.avf.services.usuario.query.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-01-28, Friday
 */
@RequiredArgsConstructor
@Service
@ProcessingGroup("grupo-usuario")
public class UsuarioEventHandlerImpl implements UsuarioEventHandler{

    private final UsuarioRepository repository;

    @EventHandler
    @Override
    public void on(UsuarioRegistradoEvent event) {
        this.repository.save(event.getUsuario());
    }

    @EventHandler
    @Override
    public void on(UsuarioAtualizadoEvent event) {
        this.repository.save(event.getUsuario());
    }

    @EventHandler
    @Override
    public void on(UsuarioRemovidoEvent event) {
        this.repository.deleteById(event.getId());
    }
}
