package br.com.sicredi.entrevista.assembleia.servico.dto;

import br.com.sicredi.entrevista.assembleia.enun.OpcaoVoto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VotoDTO {

    private Long id;

    private String cpf;

    private Long sessaoId;

    private OpcaoVoto opcao;

    @JsonIgnore
    private Long pautaId;
}
