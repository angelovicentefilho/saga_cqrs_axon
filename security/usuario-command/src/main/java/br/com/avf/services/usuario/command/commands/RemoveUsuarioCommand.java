package br.com.avf.services.usuario.command.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-01-28, Friday
 */
@Data
@AllArgsConstructor
public class RemoveUsuarioCommand {
    @TargetAggregateIdentifier
    private String id;
}
