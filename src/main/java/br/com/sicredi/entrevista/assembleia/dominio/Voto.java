package br.com.sicredi.entrevista.assembleia.teste.dominio;

import br.com.sicredi.entrevista.assembleia.teste.enun.OpcaoVoto;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "voto")
@Data
@Builder
public class Voto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cpf",nullable = false)
    private String cpf;

    @ManyToOne
    @JoinColumn(name = "sessao_id",nullable = false)
    private Sessao sessao;

    @Enumerated(EnumType.STRING)
    @Column(name = "opcao",nullable = false)
    private OpcaoVoto opcao;

}
