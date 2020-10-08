package br.com.sicredi.entrevista.assembleia.conversor;

import br.com.sicredi.entrevista.assembleia.configuracao.converter.AbstractMapper;
import br.com.sicredi.entrevista.assembleia.dominio.Voto;
import br.com.sicredi.entrevista.assembleia.dto.VotoDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class VotoConverter  extends AbstractMapper<VotoDTO, Voto> {

    private SessaoConverter sessaoConverter;

    @Override
    public VotoDTO toDto(Voto voto) {
        return VotoDTO.builder()
                .id(voto.getId())
                .cpf(voto.getCpf())
                .opcao(voto.getOpcao())
                .sessao(sessaoConverter.toDto(voto.getSessao()))
                .build();
    }

    @Override
    public Voto toEntity(VotoDTO votoDTO) {
        return Voto.builder()
                .id(votoDTO.getId())
                .cpf(votoDTO.getCpf())
                .opcao(votoDTO.getOpcao())
                .sessao(sessaoConverter.toEntity(votoDTO.getSessao()))
                .build();
    }
}
