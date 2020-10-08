package br.com.sicredi.entrevista.assembleia.teste.schedule;

import br.com.sicredi.entrevista.assembleia.teste.configuracao.kafka.Mensagem;
import br.com.sicredi.entrevista.assembleia.teste.menssageria.MensagemProducerService;
import br.com.sicredi.entrevista.assembleia.teste.servico.SessaoServico;
import br.com.sicredi.entrevista.assembleia.teste.servico.dto.SessaoDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicoAgendado {

    private final Logger logger = LoggerFactory.getLogger(ServicoAgendado.class);

    @Value(value = "${evento.topic}")
    private String topico;

    @Autowired
    private SessaoServico sessaoServico;

    @Autowired
    private MensagemProducerService mensagemService;

    @Scheduled(cron = "20 * * * * *")
    public void verificarSessaoFechada() {
        List<SessaoDTO> sessoesFechadas = sessaoServico.buscarSessaoFechadaPendente();
        logger.info("Iniciando Execução, foram econtrados {} sessões.",sessoesFechadas.size());
        sessoesFechadas.forEach(sessao -> {
            logger.info("Enviado messagem {} ",sessao);
            mensagemService.publicarMensagem(topico,Mensagem.builder()
                    .idPauta(sessao.getPautaId()).build());
        });
        logger.info("Finalizando Envio...");
    }


}
