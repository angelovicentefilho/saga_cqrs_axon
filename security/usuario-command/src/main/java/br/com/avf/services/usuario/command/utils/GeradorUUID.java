package br.com.avf.services.usuario.command.utils;

import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-01-28, Friday
 */
@Component
public class GeradorUUID {
    public String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
    }
}
