package br.com.avf.services.usuario.command.protocols;

import br.com.avf.services.usuario.common.protocols.BasicResponse;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-01-28, Friday
 */
public class RegistroUsuarioResponse extends BasicResponse {
    private String id;
    public RegistroUsuarioResponse(String mensagem) {
        super(mensagem);
    }
}
