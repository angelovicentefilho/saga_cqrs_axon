package br.com.avf.services.pedido.command.services;

import br.com.avf.services.pedido.command.commands.PedidoErroEnvioCommand;
import br.com.avf.services.pedido.command.commands.PedidoErroPagamentoCommand;
import br.com.avf.services.pedido.common.commands.CriaPedidoCommand;
import br.com.avf.services.pedido.common.utils.GeradorUUID;
import br.com.avf.services.pedido.common.utils.PedidoStatus;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-01-28, Friday
 */
@Service
@RequiredArgsConstructor
public class PedidoCommandServiceImpl implements  PedidoCommandService {

    private final CommandGateway gateway;
    private final GeradorUUID gerador;

    @Override
    public CompletableFuture<String> cria(CriaPedidoCommand command) {
        command.setIdPedido(gerador.getId());
        command.setStatus(String.valueOf(PedidoStatus.CRIADO));
        return gateway.send(command);
    }

    @Override
    public CompletableFuture<String> erroPagamento(PedidoErroPagamentoCommand command) {
        return gateway.send(command);
    }

    @Override
    public CompletableFuture<String> erroEnvio(PedidoErroEnvioCommand command) {
        return gateway.send(command);
    }
}
