package br.com.avf.services.pedido.common.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-01-28, Friday
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pedidos")
public class Pedido implements Serializable {
    private String idPedido;
    private BigDecimal valor;
    private String moeda;
    private String status;
    private String item;
}
