package br.com.avf.services.usuario.common.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-01-28, Friday
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "users")
public class Usuario {
    @Id
    private String id;
    @NotEmpty(message = "O nome é obrigatório")
    private String nome;
    @NotEmpty(message = "O Sobrenome é obrigatório")
    private String sobrenome;
    @Email(message = "Por favor, coloque um email válido")
    private String email;
    @NotNull(message = "Por favor, escolha uma conta válida.")
    private Conta conta;
}
