package br.com.avf.services.usuario.command.controllers;

import br.com.avf.services.usuario.command.commands.AtualizaUsuarioCommand;
import br.com.avf.services.usuario.common.protocols.BasicResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-01-28, Friday
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/usuarios/atualiza")
@Slf4j
public class AtualizaUsuarioController {

    private final CommandGateway gateway;

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('PRIVILEGIO_ESCRITA')")
    public ResponseEntity<BasicResponse> atualiza(@PathVariable String id, @Valid @RequestBody AtualizaUsuarioCommand command) {
        try {
            command.setId(id);
            gateway.send(command);
            return new ResponseEntity<>(new BasicResponse("Usuario atualizado com sucesso!"), HttpStatus.OK);
        } catch (Exception e) {
            String msgErro = "Erro enquanto processava a requisição de atualização com id '"+command.getId()+"'";
            log.error(msgErro);
            return new ResponseEntity<>(new BasicResponse(msgErro), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
