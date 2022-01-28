package br.com.avf.services.usuario.query.utils;

import br.com.avf.services.usuario.query.protocols.UsuarioQueryResponse;
import br.com.avf.services.usuario.query.queries.UsuarioQuery;
import lombok.RequiredArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Component;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-01-28, Friday
 */
@Component
@RequiredArgsConstructor
public class ResponseJoin {

    private final QueryGateway gateway;

    public UsuarioQueryResponse join(UsuarioQuery query) {
        return gateway.query(query, ResponseTypes.instanceOf(UsuarioQueryResponse.class)).join();
    }

}
