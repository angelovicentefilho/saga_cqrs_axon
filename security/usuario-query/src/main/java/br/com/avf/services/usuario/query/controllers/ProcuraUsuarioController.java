package br.com.avf.services.usuario.query.controllers;

import br.com.avf.services.usuario.query.protocols.UsuarioQueryResponse;
import br.com.avf.services.usuario.query.queries.ProcuraUsuariosQuery;
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
public class ProcuraUsuarioController {

    private final ResponseJoin responseJoin;

    @GetMapping("/filtro/{filtro}")
    @PreAuthorize("hasAuthority('PRIVILEGIO_LEITURA')")
    public ResponseEntity<UsuarioQueryResponse> procura(@PathVariable String filtro) {
        try {
            ProcuraUsuariosQuery query = new ProcuraUsuariosQuery(filtro);
            UsuarioQueryResponse response = responseJoin.join(query);
            if (response == null || response.getUsuarios() == null) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            String msgErro = "Erro ao completar a busca de de usuários pelo filtro '"+filtro+"'";
            log.error(msgErro);
            return new ResponseEntity<>(new UsuarioQueryResponse(msgErro), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
