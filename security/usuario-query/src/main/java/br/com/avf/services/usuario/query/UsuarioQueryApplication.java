package br.com.avf.services.usuario.query;

import br.com.avf.services.usuario.common.configurations.CustomAxonConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
@SpringBootApplication
@Import({CustomAxonConfiguration.class})
public class UsuarioQueryApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsuarioQueryApplication.class, args);
	}

}
