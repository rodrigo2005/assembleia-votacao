package br.com.sicredi.entrevista.assembleia.configuracao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mensagem {

    private Long idPauta;

    private String msg;

}
