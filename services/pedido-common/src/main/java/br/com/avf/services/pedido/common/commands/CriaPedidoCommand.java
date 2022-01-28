package br.com.avf.services.pedido.common.commands;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.math.BigDecimal;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-01-28, Friday
 */
@Data
@Builder
public class CriaPedidoCommand {
    @TargetAggregateIdentifier
    private String idPedido;
    private String tipoItem;
    private String moeda;
    private String status;
    private BigDecimal valor;
}
