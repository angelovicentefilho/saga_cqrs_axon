package br.com.avf.services.usuario.command.controllers;

import br.com.avf.services.usuario.command.commands.RegistroUsuarioCommand;
import br.com.avf.services.usuario.command.protocols.RegistroUsuarioResponse;
import br.com.avf.services.usuario.command.utils.GeradorUUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-01-28, Friday
 */
@RestController
@RequestMapping("/api/v1/usuarios/registro")
@RequiredArgsConstructor
@Slf4j
public class RegistroUsuarioController {

    private final CommandGateway gateway;
    private final GeradorUUID gerador;

    @PostMapping
    @PreAuthorize("hasAuthority('PRIVILEGIO_ESCRITA')")
    public ResponseEntity<RegistroUsuarioResponse> registro(@Valid @RequestBody RegistroUsuarioCommand command) {
        command.setId(gerador.getUUID());
        try {
            gateway.send(command);
            return new ResponseEntity<>(new RegistroUsuarioResponse("Usuario registrado com sucesso!"), HttpStatus.CREATED);
        } catch (Exception e) {
            String msgErro = "Erro enquanto processava a requisição de registro do usuário com ID: '"+command.getId()+"'";
            log.error(msgErro);
            return new ResponseEntity<>(new RegistroUsuarioResponse(msgErro), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
