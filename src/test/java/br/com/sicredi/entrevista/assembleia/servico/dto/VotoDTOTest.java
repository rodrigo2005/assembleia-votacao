package br.com.sicredi.entrevista.assembleia.servico.dto;

import br.com.sicredi.entrevista.assembleia.enun.OpcaoVotoTest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VotoDTOTest {

    private Long id;

    private String cpf;

    private Long sessaoId;

    private OpcaoVotoTest opcao;

    @JsonIgnore
    private Long pautaId;
}
