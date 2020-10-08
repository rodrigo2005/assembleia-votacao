package br.com.sicredi.entrevista.assembleia.teste.configuracao.kafka;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Mensagem {
    private Long idPauta;
}
