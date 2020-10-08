package br.com.sicredi.entrevista.assembleia.teste.servico.conversor;

import br.com.sicredi.entrevista.assembleia.teste.dominio.Sessao;
import br.com.sicredi.entrevista.assembleia.teste.dominio.Voto;
import br.com.sicredi.entrevista.assembleia.teste.servico.dto.VotoDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class VotoConverter  extends AbstractConverter<VotoDTO, Voto> {

    @Override
    public VotoDTO toDto(Voto voto) {
        return VotoDTO.builder()
                .id(voto.getId())
                .cpf(voto.getCpf())
                .opcao(voto.getOpcao())
                .sessaoId(voto.getSessao().getId())
                .pautaId(voto.getSessao().getPauta().getId())
                .build();
    }

    public VotoDTO toDto(Voto voto, Long pautaId) {
        return VotoDTO.builder()
                .id(voto.getId())
                .cpf(voto.getCpf())
                .opcao(voto.getOpcao())
                .sessaoId(voto.getSessao().getId())
                .pautaId(pautaId)
                .build();
    }

    @Override
    public Voto toEntity(VotoDTO votoDTO) {
        return Voto.builder()
                .id(votoDTO.getId())
                .cpf(votoDTO.getCpf())
                .opcao(votoDTO.getOpcao())
                .sessao(Sessao.builder().id(votoDTO.getSessaoId()).build())
                .build();
    }
}
