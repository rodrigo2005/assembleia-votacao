package br.com.sicredi.entrevista.assembleia.api.v1.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Builder
public class SessaoRequest {


    @NotNull(message = "Este campo e de preenchido obrigatório.")
    private LocalDateTime dataHoraInicio;

    @Min(value = 0, message = "Valor do campo deve ser maior ou igual a zero.")
    private Integer duracaoMinutos;

    @NotNull(message = "O ID da pauta é obrigatório.")
    private Long pautaId;


    public LocalDateTime getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(LocalDateTime dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public Integer getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public void setDuracaoMinutos(Integer duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }

    public Long getPautaId() {
        return pautaId;
    }

    public void setPautaId(Long pautaId) {
        this.pautaId = pautaId;
    }
}
