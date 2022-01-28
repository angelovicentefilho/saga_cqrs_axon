package br.com.avf.services.usuario.query.queries;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-01-28, Friday
 */
@Data
@AllArgsConstructor
public class ProcuraUsuariosQuery implements UsuarioQuery{
    private String filtro;
}
