package br.com.avf.services.usuario.command.controllers;

import br.com.avf.services.usuario.command.commands.RemoveUsuarioCommand;
import br.com.avf.services.usuario.common.protocols.BasicResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-01-28, Friday
 */
@RestController
@RequestMapping("/api/v1/usuarios/remove")
@Slf4j
@RequiredArgsConstructor
public class RemoveUsuarioController {

    private final CommandGateway gateway;

    public ResponseEntity<BasicResponse> remove(@PathVariable String id) {
        try {
            gateway.send(new RemoveUsuarioCommand(id));
            return new ResponseEntity<>(new BasicResponse("Usuario removido com sucesso!"), HttpStatus.OK);
        } catch (Exception e) {
            String msgErro = "Erro enquanto processava a requisição de delete com id '"+id+"'";
            log.error(msgErro);
            return new ResponseEntity<>(new BasicResponse(msgErro), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
