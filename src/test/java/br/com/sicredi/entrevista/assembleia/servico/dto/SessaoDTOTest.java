package br.com.sicredi.entrevista.assembleia.servico.dto;

import br.com.sicredi.entrevista.assembleia.enun.SituacaoMensagemFimSessao;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class SessaoDTOTest {

    private Long id;

    @JsonIgnore
    private Integer minutos;

    private LocalDateTime inicioVotacao;

    private LocalDateTime fimVotacao;

    private SituacaoMensagemFimSessao situacaoMensagemFimSessao;

    private Long pautaId;

}
