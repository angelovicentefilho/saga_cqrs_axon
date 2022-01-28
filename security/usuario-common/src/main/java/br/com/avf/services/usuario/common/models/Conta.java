package br.com.avf.services.usuario.common.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-01-28, Friday
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Conta {
    @Size(message = "O usuário deve ter pelo menos 2 caracteres", min = 2)
    private String usuario;
    @Size(message = "A senha deve ter pelo menos 7 caracteres", min = 7)
    private String senha;
    @NotNull(message = "Especifique as funções")
    private List<Funcao> funcoes;
}
