package br.com.sicredi.entrevista.assembleia.teste.servico.dto;

import br.com.sicredi.entrevista.assembleia.teste.enun.OpcaoVoto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResultadoDTO {

    private OpcaoVoto opcao;

    private Long totalVotos;

}
