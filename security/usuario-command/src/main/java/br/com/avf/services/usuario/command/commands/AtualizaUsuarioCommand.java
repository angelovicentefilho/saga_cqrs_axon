package br.com.avf.services.usuario.command.commands;

import br.com.avf.services.usuario.common.models.Usuario;
import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-01-28, Friday
 */
@Data
@Builder
public class AtualizaUsuarioCommand {
    @TargetAggregateIdentifier
    private String id;
    private Usuario usuario;
}
