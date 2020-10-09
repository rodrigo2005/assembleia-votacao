package br.com.sicredi.entrevista.assembleia.api.v1.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PautaRequest {

    @NotNull(message = "Este campo e de preenchido obrigatório.")
    @NotEmpty(message = "Este campo e de preenchido obrigatório.")
    private String descricao;


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
