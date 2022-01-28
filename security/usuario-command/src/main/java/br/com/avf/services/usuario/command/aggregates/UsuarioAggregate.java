package br.com.avf.services.usuario.command.aggregates;

import br.com.avf.services.usuario.command.commands.AtualizaUsuarioCommand;
import br.com.avf.services.usuario.command.commands.RegistroUsuarioCommand;
import br.com.avf.services.usuario.command.commands.RemoveUsuarioCommand;
import br.com.avf.services.usuario.command.securities.SenhaEncoderImpl;
import br.com.avf.services.usuario.command.utils.GeradorUUID;
import br.com.avf.services.usuario.common.events.UsuarioAtualizadoEvent;
import br.com.avf.services.usuario.common.events.UsuarioRegistradoEvent;
import br.com.avf.services.usuario.common.events.UsuarioRemovidoEvent;
import br.com.avf.services.usuario.common.models.Usuario;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;
import static org.axonframework.modelling.command.AggregateLifecycle.markDeleted;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-01-28, Friday
 */
@Aggregate
public class UsuarioAggregate {
    @AggregateIdentifier
    private String id;
    private Usuario usuario;

    private final SenhaEncoderImpl encoder = new SenhaEncoderImpl();
    private final GeradorUUID geradorUUID = new GeradorUUID();

    public UsuarioAggregate(){
        //Para uso do Axon
    }

    @CommandHandler
    public UsuarioAggregate(RegistroUsuarioCommand command) {
        Usuario newUsuario = command.getUsuario();
        newUsuario.setId(command.getId());
        String senha = newUsuario.getConta().getSenha();
        String hashSenha = encoder.hashSenha(senha);
        newUsuario.getConta().setSenha(hashSenha);
        apply(UsuarioRegistradoEvent.builder()
                .id(command.getId())
                .usuario(newUsuario)
                .build());
    }

    @CommandHandler
    public void handle(AtualizaUsuarioCommand command) {
        Usuario updUsuario = command.getUsuario();
        updUsuario.setId(command.getId());
        String senha = updUsuario.getConta().getSenha();
        String hashSenha = encoder.hashSenha(senha);
        updUsuario.getConta().setSenha(hashSenha);
        apply(UsuarioAtualizadoEvent.builder()
                .id(geradorUUID.getUUID())
                .usuario(updUsuario)
                .build());
    }

    @CommandHandler
    public void handle(RemoveUsuarioCommand command) {
        UsuarioRemovidoEvent event = new UsuarioRemovidoEvent();
        event.setId(command.getId());
        apply(event);
    }

    @EventSourcingHandler
    public void on(UsuarioRegistradoEvent event) {
        this.id = event.getId();
        this.usuario = event.getUsuario();
    }

    @EventSourcingHandler
    public void on(UsuarioAtualizadoEvent event) {
        this.usuario = event.getUsuario();
    }

    @EventSourcingHandler
    public void on(UsuarioRemovidoEvent event) {
        markDeleted();
    }

}
