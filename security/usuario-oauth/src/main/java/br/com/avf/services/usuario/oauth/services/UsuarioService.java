package br.com.avf.services.usuario.oauth.services;

import br.com.avf.services.usuario.common.models.Conta;
import br.com.avf.services.usuario.common.models.Usuario;
import br.com.avf.services.usuario.oauth.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-01-28, Friday
 */
@Service
@RequiredArgsConstructor
public class UsuarioService implements UserDetailsService {
    private final UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
        Optional<Usuario> optional = repository.findByUsuario(usuario);
        if (!optional.isPresent()) {
            throw new UsernameNotFoundException("Usuario ou senha incorreta");
        }
        Conta conta = optional.get().getConta();
        return User.withUsername(conta.getUsuario())
                .password(conta.getSenha())
                .authorities(conta.getFuncoes())
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }
}
