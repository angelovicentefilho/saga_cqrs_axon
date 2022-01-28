package br.com.avf.services.pedido.common.commands;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-01-28, Friday
 */
@Data
@Builder
public class ProcessaPagamentoCommand {
    @TargetAggregateIdentifier
    private String idPagamento;
    private String idPedido;
}
