package br.com.avf.services.usuario.command.securities;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-01-28, Friday
 */
@Service
public class SenhaEncoderImpl implements SenhaEncoder {

    @Override
    public String hashSenha(String senha) {
        return new BCryptPasswordEncoder(12).encode(senha);
    }
}
