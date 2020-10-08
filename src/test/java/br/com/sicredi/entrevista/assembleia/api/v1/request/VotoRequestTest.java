package br.com.sicredi.entrevista.assembleia.api.v1.request;

import br.com.sicredi.entrevista.assembleia.enun.OpcaoVoto;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class VotoRequestTest {

    @CPF(message = "Este campo deve possuir um CPF com númeração válida.")
    private String cpf;

    @NotNull(message = "O ID da sessão e obrigatório.")
    private Long sessaoId;

    @NotNull(message = "Deve ser informado uma opçao de voto, as opções são SIM ou NAO.")
    private OpcaoVoto opcao;
}
