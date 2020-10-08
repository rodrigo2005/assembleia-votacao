package br.com.sicredi.entrevista.assembleia.api.v1.converter;

import br.com.sicredi.entrevista.assembleia.api.v1.request.VotoRequest;
import br.com.sicredi.entrevista.assembleia.servico.dto.VotoDTO;
import org.springframework.stereotype.Component;

@Component
public class VotoRequestConverter {


    public VotoDTO toDTO(VotoRequest votoRequest){
        return VotoDTO.builder()
                .cpf(votoRequest.getCpf())
                .opcao(votoRequest.getOpcao())
                .sessaoId(votoRequest.getSessaoId())
                .build();
    }

}
