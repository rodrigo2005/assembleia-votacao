package br.com.sicredi.entrevista.assembleia.dominio;

import br.com.sicredi.entrevista.assembleia.enun.SituacaoMensagemFimSessao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "sessao")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sessao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "inicioVotacao",nullable = false)
    private LocalDateTime inicioVotacao;

    @Column(name = "fimVotacao",nullable = false)
    private LocalDateTime fimVotacao;

    @Enumerated(EnumType.STRING)
    @Column(name = "situacaoMensagemFimSessao",nullable = false)
    private SituacaoMensagemFimSessao situacaoMensagemFimSessao;

    @OneToOne()
    @JoinColumn(name = "pauta_id",nullable = false)
    private Pauta pauta;

    public void adicionarDataFinal(Integer minutos){
        Integer totalMinutos = minutos != null && minutos > 0 ? minutos : 1;
        this.fimVotacao =  this.inicioVotacao.plusMinutes(totalMinutos);
    }

    public void adicionarSituacaoAtual(SituacaoMensagemFimSessao situacaoAtual){
        this.situacaoMensagemFimSessao = situacaoAtual;
    }
}
