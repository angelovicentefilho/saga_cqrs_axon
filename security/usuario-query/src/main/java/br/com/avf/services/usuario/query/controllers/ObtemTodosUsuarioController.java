package br.com.avf.services.usuario.query.controllers;

import br.com.avf.services.usuario.query.protocols.UsuarioQueryResponse;
import br.com.avf.services.usuario.query.queries.ObtemTodosUsuariosQuery;
import br.com.avf.services.usuario.query.utils.ResponseJoin;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-01-28, Friday
 */
@RestController
@RequestMapping("/api/v1/usuarios")
@RequiredArgsConstructor
@Slf4j
public class ObtemTodosUsuarioController {

    private final ResponseJoin responseJoin;

    @GetMapping
    @PreAuthorize("hasAuthority('PRIVILEGIO_LEITURA')")
    public ResponseEntity<UsuarioQueryResponse> obtemTodosUsuarios() {
        try {
            UsuarioQueryResponse response = responseJoin.join(new ObtemTodosUsuariosQuery());
            if (response == null || response.getUsuarios() == null) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            String msgErro = "Falha ao localizar todos os usuários";
            log.error(msgErro);
            return new ResponseEntity<>(new UsuarioQueryResponse(msgErro), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
