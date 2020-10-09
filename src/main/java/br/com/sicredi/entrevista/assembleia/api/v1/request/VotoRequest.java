package br.com.sicredi.entrevista.assembleia.api.v1.request;

import br.com.sicredi.entrevista.assembleia.enun.OpcaoVoto;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;
import javax.validation.constraints.NotNull;

@Builder
public class VotoRequest {

    @CPF(message = "Este campo deve possuir um CPF com númeração válida.")
    private String cpf;

    @NotNull(message = "O ID da sessão e obrigatório.")
    private Long sessaoId;

    @NotNull(message = "Deve ser informado uma opçao de voto, as opções são SIM ou NAO.")
    private OpcaoVoto opcao;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Long getSessaoId() {
        return sessaoId;
    }

    public void setSessaoId(Long sessaoId) {
        this.sessaoId = sessaoId;
    }

    public OpcaoVoto getOpcao() {
        return opcao;
    }

    public void setOpcao(OpcaoVoto opcao) {
        this.opcao = opcao;
    }
}
