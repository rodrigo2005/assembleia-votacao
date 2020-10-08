package br.com.sicredi.entrevista.assembleia.api.v1.converter;

import br.com.sicredi.entrevista.assembleia.api.v1.request.PautaRequest;
import br.com.sicredi.entrevista.assembleia.servico.dto.PautaDTO;
import org.springframework.stereotype.Component;

@Component
public class PautaRequestConverter {

    public PautaDTO toDTO(PautaRequest pautaRequest){
        return PautaDTO.builder()
                .nome(pautaRequest.getDescricao())
                .build();
    }

}
