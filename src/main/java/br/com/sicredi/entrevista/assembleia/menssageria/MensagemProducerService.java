package br.com.sicredi.entrevista.assembleia.menssageria;

import br.com.sicredi.entrevista.assembleia.configuracao.kafka.Mensagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MensagemProducerService {

    @Autowired
    private KafkaTemplate<Long, Mensagem> kafkaTemplate;

    public void publicarMensagem(String topic,Mensagem mensagem){
        kafkaTemplate.send(topic,mensagem);
    }


}
