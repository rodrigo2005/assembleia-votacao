package br.com.sicredi.entrevista.assembleia.conversor;

import br.com.sicredi.entrevista.assembleia.configuracao.converter.AbstractMapper;
import br.com.sicredi.entrevista.assembleia.dominio.Pauta;
import br.com.sicredi.entrevista.assembleia.dto.PautaDTO;
import org.springframework.stereotype.Component;

@Component
public class PautaConverter extends AbstractMapper<PautaDTO, Pauta> {


    @Override
    public PautaDTO toDto(Pauta pauta) {
        return PautaDTO.builder()
                .id(pauta.getId())
                .nome(pauta.getNome()).build();
    }

    @Override
    public Pauta toEntity(PautaDTO pautaDTO) {
        return Pauta.builder()
                .id(pautaDTO.getId())
                .nome(pautaDTO.getNome()).build();
    }
}
