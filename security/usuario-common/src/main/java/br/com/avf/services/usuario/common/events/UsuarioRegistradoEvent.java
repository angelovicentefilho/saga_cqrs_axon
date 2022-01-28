package br.com.avf.services.usuario.common.events;

import br.com.avf.services.usuario.common.models.Usuario;
import lombok.Builder;
import lombok.Data;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-01-28, Friday
 */
@Data
@Builder
public class UsuarioRegistradoEvent {
    private String id;
    private Usuario usuario;
}
