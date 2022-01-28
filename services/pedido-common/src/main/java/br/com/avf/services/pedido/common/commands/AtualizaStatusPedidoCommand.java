package br.com.avf.services.pedido.common.commands;

import lombok.Builder;
import lombok.Data;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-01-28, Friday
 */
@Data
@Builder
public class AtualizaStatusPedidoCommand {
    private String idPedido;
    private String status;
}
