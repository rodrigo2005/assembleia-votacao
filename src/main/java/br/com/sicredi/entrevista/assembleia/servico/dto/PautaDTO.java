package br.com.sicredi.entrevista.assembleia.teste.servico.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PautaDTO {

    private Long id;

    private String nome;
}
