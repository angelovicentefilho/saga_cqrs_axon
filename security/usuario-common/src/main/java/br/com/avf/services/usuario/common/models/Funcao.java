package br.com.avf.services.usuario.common.models;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-01-28, Friday
 */
public enum Funcao implements GrantedAuthority {
    PRIVILEGIO_LEITURA, PRIVILEGIO_ESCRITA;

    @Override
    public String getAuthority() {
        return name();
    }
}
