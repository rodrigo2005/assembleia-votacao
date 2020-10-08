package br.com.sicredi.entrevista.assembleia.client.dto;

import lombok.Data;

@Data
public class ValidarCPF {

    private static final String ABLE_TO_VOTE = "ABLE_TO_VOTE";

    private String status;

    public boolean isValido(){
        return ABLE_TO_VOTE.equals(this.status);
    }

}
