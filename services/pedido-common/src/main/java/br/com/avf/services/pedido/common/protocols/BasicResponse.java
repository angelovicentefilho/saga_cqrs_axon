package br.com.avf.services.pedido.common.protocols;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-01-28, Friday
 */
@Data
@AllArgsConstructor
public class BasicResponse {
    private String mensagem;
}
