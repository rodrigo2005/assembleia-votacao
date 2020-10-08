package br.com.sicredi.entrevista.assembleia.menssageria;

import br.com.sicredi.entrevista.assembleia.configuracao.kafka.Mensagem;
import br.com.sicredi.entrevista.assembleia.servico.SessaoServico;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MensagemConsumerService {

    private final Logger logger = LoggerFactory.getLogger(MensagemConsumerService.class);

    private SessaoServico sessaoServico;

    @KafkaListener(topics = "votacao_sessao_finalizada", groupId = "grupo")
    public void listenGroupFoo(Mensagem mensagem) {
        logger.info("Iniciando fechamento da sessão da pauta: {} ",mensagem.getIdPauta());
        sessaoServico.confirmarEnvioMenssagemFechamento(mensagem.getIdPauta());
        logger.info("Fechamento da sessão realizado.");

    }


}
