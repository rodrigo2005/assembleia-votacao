package br.com.sicredi.entrevista.assembleia.conversor;

import br.com.sicredi.entrevista.assembleia.configuracao.converter.AbstractMapper;
import br.com.sicredi.entrevista.assembleia.dominio.Sessao;
import br.com.sicredi.entrevista.assembleia.dto.SessaoDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SessaoConverter extends AbstractMapper<SessaoDTO, Sessao> {

    private PautaConverter pautaConverter;

    @Override
    public SessaoDTO toDto(Sessao sessao) {
        return SessaoDTO.builder()
                .id(sessao.getId())
                .inicioVotacao(sessao.getInicioVotacao())
                .fimVotacao(sessao.getFimVotacao())
                .msgFechamentoPublicada(sessao.getMsgFechamentoPublicada())
                .pauta(pautaConverter.toDto(sessao.getPauta()))
                .build();
    }

    @Override
    public Sessao toEntity(SessaoDTO sessaoDTO) {
        return Sessao.builder()
                .id(sessaoDTO.getId())
                .inicioVotacao(sessaoDTO.getInicioVotacao())
                .fimVotacao(sessaoDTO.getFimVotacao())
                .msgFechamentoPublicada(sessaoDTO.getMsgFechamentoPublicada())
                .pauta(pautaConverter.toEntity(sessaoDTO.getPauta()))
                .build();
    }
}
