package br.com.avf.services.pedido.command.services;

import br.com.avf.services.pedido.command.commands.PedidoErroEnvioCommand;
import br.com.avf.services.pedido.command.commands.PedidoErroPagamentoCommand;
import br.com.avf.services.pedido.common.commands.CriaPedidoCommand;

import java.util.concurrent.CompletableFuture;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-01-28, Friday
 */
public interface PedidoCommandService {

    CompletableFuture<String> cria(CriaPedidoCommand command);
    CompletableFuture<String> erroPagamento(PedidoErroPagamentoCommand command);
    CompletableFuture<String> erroEnvio(PedidoErroEnvioCommand command);
}
