package br.com.avf.services.usuario.query.protocols;

import br.com.avf.services.usuario.common.models.Usuario;
import br.com.avf.services.usuario.common.protocols.BasicResponse;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-01-28, Friday
 */
public class UsuarioQueryResponse extends BasicResponse {
    private List<Usuario> usuarios;
    public UsuarioQueryResponse(String mensagem) {
        super(mensagem);
    }

    public UsuarioQueryResponse(String mensagem, Usuario usuario) {
        super(mensagem);
        this.usuarios = Lists.newArrayList();
        this.usuarios.add(usuario);
    }

    public UsuarioQueryResponse(Usuario usuario) {
        super(null);
        this.usuarios = Lists.newArrayList();
        this.usuarios.add(usuario);
    }

    public UsuarioQueryResponse(List<Usuario> usuarios) {
        super(null);
        this.usuarios = usuarios;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
