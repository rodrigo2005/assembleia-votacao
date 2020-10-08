package br.com.sicredi.entrevista.assembleia.teste.servico.conversor;

import br.com.sicredi.entrevista.assembleia.teste.dominio.Pauta;
import br.com.sicredi.entrevista.assembleia.teste.dominio.Sessao;
import br.com.sicredi.entrevista.assembleia.teste.servico.dto.SessaoDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SessaoConverter extends AbstractConverter<SessaoDTO, Sessao> {

    @Override
    public SessaoDTO toDto(Sessao sessao) {
        return SessaoDTO.builder()
                .id(sessao.getId())
                .inicioVotacao(sessao.getInicioVotacao())
                .fimVotacao(sessao.getFimVotacao())
                .situacaoMensagemFimSessao(sessao.getSituacaoMensagemFimSessao())
                .pautaId(sessao.getPauta().getId())
                .build();
    }

    @Override
    public Sessao toEntity(SessaoDTO sessaoDTO) {
        return Sessao.builder()
                .id(sessaoDTO.getId())
                .inicioVotacao(sessaoDTO.getInicioVotacao())
                .fimVotacao(sessaoDTO.getFimVotacao())
                .situacaoMensagemFimSessao(sessaoDTO.getSituacaoMensagemFimSessao())
                .pauta(Pauta.builder().id(sessaoDTO.getPautaId()).build())
                .build();
    }
}
