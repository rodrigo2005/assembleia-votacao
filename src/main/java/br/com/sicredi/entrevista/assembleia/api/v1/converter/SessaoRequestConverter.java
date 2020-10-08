package br.com.sicredi.entrevista.assembleia.api.v1.converter;

import br.com.sicredi.entrevista.assembleia.api.v1.request.SessaoRequest;
import br.com.sicredi.entrevista.assembleia.servico.dto.SessaoDTO;
import org.springframework.stereotype.Component;

@Component
public class SessaoRequestConverter {

    public SessaoDTO toDTO(SessaoRequest sessaoRequest){
        return SessaoDTO.builder()
                .minutos(sessaoRequest.getDuracaoMinutos())
                .inicioVotacao(sessaoRequest.getDataHoraInicio())
                .pautaId(sessaoRequest.getPautaId())
                .build();




    }


}
