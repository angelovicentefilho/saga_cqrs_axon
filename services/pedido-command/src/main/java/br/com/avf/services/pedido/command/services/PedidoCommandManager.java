package br.com.avf.services.pedido.command.services;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-01-28, Friday
 */
@Component
public abstract class PedidoCommandManager implements Serializable {
    transient CommandGateway gateway;

    @Autowired
    public void setCommandGateway(CommandGateway gateway) {
        this.gateway = gateway;
    }
}
