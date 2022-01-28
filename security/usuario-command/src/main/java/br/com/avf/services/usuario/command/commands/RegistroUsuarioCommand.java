package br.com.avf.services.usuario.command.commands;

import br.com.avf.services.usuario.common.models.Usuario;
import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-01-28, Friday
 */
@Data
@Builder
public class RegistroUsuarioCommand {
    @TargetAggregateIdentifier
    private String id;
    @NotNull(message = "Coloque os detalhes do usuário")
    @Valid
    private Usuario usuario;
}
