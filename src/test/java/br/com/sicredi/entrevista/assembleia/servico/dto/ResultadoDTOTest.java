package br.com.sicredi.entrevista.assembleia.servico.dto;

import br.com.sicredi.entrevista.assembleia.enun.OpcaoVotoTest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResultadoDTOTest {

    private OpcaoVotoTest opcao;

    private Long totalVotos;

}
