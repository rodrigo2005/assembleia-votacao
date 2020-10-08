package br.com.sicredi.entrevista.assembleia.repositorio;

import br.com.sicredi.entrevista.assembleia.dominio.Sessao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SessaoRepositorio extends JpaRepository<Sessao, Long> {

    @Query("select s from Sessao s where s.situacaoMensagemFimSessao = 'PENDENTE' and s.fimVotacao < current_timestamp")
    List<Sessao> buscarSessaoFechadaPendente();

    @Query("select s from Sessao s where s.situacaoMensagemFimSessao = 'PENDENTE' and s.pauta.id = ?1 ")
    Sessao buscarSessaoPorPauta(Long pautaId);

    @Query("select COUNT(s) > 0 from Sessao s where s.id = ?1 and s.fimVotacao > current_timestamp  ")
    boolean existeSessaoAberta(Long sessaoId);

    @Query("select COUNT(s) > 0 from Sessao s where  s.pauta.id = ?1")
    boolean existeSessao(Long pautaId);




}
