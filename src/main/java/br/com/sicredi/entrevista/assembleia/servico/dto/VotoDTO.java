package br.com.sicredi.entrevista.assembleia.dto;

import br.com.sicredi.entrevista.assembleia.enun.OpcaoSimNaoEnum;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VotoDTO {

    private Long id;

    private String cpf;

    private SessaoDTO sessao;

    private OpcaoSimNaoEnum opcao;

}
