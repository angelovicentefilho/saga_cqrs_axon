package br.com.avf.services.pedido.common.events;

import lombok.Builder;
import lombok.Data;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-01-28, Friday
 */
@Data
@Builder
public class PedidoEnviadoEvent {
    private String idEnvio;
    private String idPedido;
    private String idPagamento;
}
