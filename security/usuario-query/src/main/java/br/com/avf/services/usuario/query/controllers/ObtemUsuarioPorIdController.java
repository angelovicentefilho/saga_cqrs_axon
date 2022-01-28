package br.com.avf.services.usuario.query.controllers;

import br.com.avf.services.usuario.query.protocols.UsuarioQueryResponse;
import br.com.avf.services.usuario.query.queries.ObtemUsuarioPorIdQuery;
import br.com.avf.services.usuario.query.utils.ResponseJoin;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
public class ObtemUsuarioPorIdController {

    private final ResponseJoin responseJoin;

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('PRIVILEGIO_LEITURA')")
    public ResponseEntity<UsuarioQueryResponse> obtemPorId(@PathVariable String id) {
        ObtemUsuarioPorIdQuery query = new ObtemUsuarioPorIdQuery(id);
        UsuarioQueryResponse response = responseJoin.join(query);
        if (response == null || response.getUsuarios() == null) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
