package br.com.sicredi.entrevista.assembleia.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class SessaoDTO {

    private Long id;

    private LocalDateTime inicioVotacao;

    private LocalDateTime fimVotacao;

    private Boolean msgFechamentoPublicada;

    private PautaDTO pauta;

}
