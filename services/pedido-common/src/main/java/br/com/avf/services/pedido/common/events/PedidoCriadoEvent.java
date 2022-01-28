package br.com.avf.services.pedido.common.events;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-01-28, Friday
 */
@Data
@Builder
public class PedidoCriadoEvent {
    private String idPedido;
    private String tipoItem;
    private String moeda;
    private String status;
    private BigDecimal valor;
}
