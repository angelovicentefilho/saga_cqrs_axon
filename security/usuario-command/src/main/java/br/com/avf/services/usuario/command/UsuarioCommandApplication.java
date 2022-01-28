package br.com.avf.services.usuario.command;

import br.com.avf.services.usuario.command.commands.RegistroUsuarioCommand;
import br.com.avf.services.usuario.command.controllers.RegistroUsuarioController;
import br.com.avf.services.usuario.command.utils.GeradorUUID;
import br.com.avf.services.usuario.common.configurations.CustomAxonConfiguration;
import br.com.avf.services.usuario.common.models.Conta;
import br.com.avf.services.usuario.common.models.Funcao;
import br.com.avf.services.usuario.common.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import java.util.Arrays;
import java.util.stream.Collectors;

@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
@SpringBootApplication
@Import({CustomAxonConfiguration.class})
public class UsuarioCommandApplication implements CommandLineRunner {

	@Autowired
	private GeradorUUID gerador;
	@Autowired
	private RegistroUsuarioController controller;

	public static void main(String[] args) {
		SpringApplication.run(UsuarioCommandApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Para usar isso tem que desabilitar no controller a segurança
//		Usuario[] usuarios = {
//				new Usuario(gerador.getUUID(), "Angelo", "Vicente Filho", "angelovicentefilho@gmail.com", new Conta("angelo", "angelo", Arrays.asList(Funcao.PRIVILEGIO_ESCRITA, Funcao.PRIVILEGIO_LEITURA)))
//		};
//		Arrays.stream(usuarios).collect(Collectors.toList()).forEach(usuario -> this.controller.registro(RegistroUsuarioCommand.builder()
//				.id(usuario.getId())
//				.usuario(usuario)
//				.build()));
	}
}
