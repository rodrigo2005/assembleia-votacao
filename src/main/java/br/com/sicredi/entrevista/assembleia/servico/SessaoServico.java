package br.com.sicredi.entrevista.assembleia.servico;

import br.com.sicredi.entrevista.assembleia.dominio.Sessao;
import br.com.sicredi.entrevista.assembleia.enun.SituacaoMensagemFimSessao;
import br.com.sicredi.entrevista.assembleia.excecao.NegocioException;
import br.com.sicredi.entrevista.assembleia.excecao.ResourceNotFoundException;
import br.com.sicredi.entrevista.assembleia.repositorio.SessaoRepositorio;
import br.com.sicredi.entrevista.assembleia.servico.conversor.SessaoConverter;
import br.com.sicredi.entrevista.assembleia.servico.dto.SessaoDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class SessaoServico {

    private SessaoRepositorio sessaoRepositorio;
    private SessaoConverter sessaoConverter;
    private PautaServico pautaServico;

    @Transactional
    public SessaoDTO criar(SessaoDTO sessaoDTO){
        pautaJaPossuiSessao(sessaoDTO.getPautaId());
        pautaServico.existePauta(sessaoDTO.getPautaId());

        Sessao sessao = sessaoConverter.toEntity(sessaoDTO);
        sessao.adicionarDataFinal(sessaoDTO.getMinutos());
        sessao.adicionarSituacaoAtual(SituacaoMensagemFimSessao.PENDENTE);
        sessaoRepositorio.save(sessao);
        return sessaoConverter.toDto(sessao);
    }

    @Transactional
    public void confirmarEnvioMenssagemFechamento(Long pautaId){
        Sessao sessao = sessaoRepositorio.buscarSessaoPorPauta(pautaId);
        sessao.adicionarSituacaoAtual(SituacaoMensagemFimSessao.ENVIADA);
    }

    public List<SessaoDTO> buscarSessaoFechadaPendente(){
        return sessaoConverter.toDto(sessaoRepositorio.buscarSessaoFechadaPendente());
    }

    public boolean existeSessaoAberta(Long sessaoId){
    return sessaoRepositorio.existeSessaoAberta(sessaoId);
    }

    public void sessaoExiste(Long sessaoId){
        if(!sessaoRepositorio.existsById(sessaoId)){
            throw new IllegalArgumentException("Não foi encontrado sessão com o ID informado.");
        }
    }

    private void pautaJaPossuiSessao(Long pautaId){
        if(sessaoRepositorio.existeSessao(pautaId)){
            throw new NegocioException("Não foi possível incluir uma sessão, pauta já possui uma sessão vinculada.");
        }
    }

}
