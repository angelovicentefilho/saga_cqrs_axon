package br.com.avf.services.usuario.command.securities;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-01-28, Friday
 */
public interface SenhaEncoder {
    String hashSenha(String senha);
}
