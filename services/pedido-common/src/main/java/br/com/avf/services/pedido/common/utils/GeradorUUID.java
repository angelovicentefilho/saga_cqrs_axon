package br.com.avf.services.pedido.common.utils;

import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-01-28, Friday
 */
@Component
public class GeradorUUID {

    public String getId() {
        return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
    }
}
