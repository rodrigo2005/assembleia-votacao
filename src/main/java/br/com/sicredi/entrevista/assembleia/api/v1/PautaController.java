package br.com.sicredi.entrevista.assembleia.api.v1;

import br.com.sicredi.entrevista.assembleia.configuracao.kafka.Mensagem;
import br.com.sicredi.entrevista.assembleia.dto.PautaDTO;
import br.com.sicredi.entrevista.assembleia.servico.PautaServico;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/v1/pauta")
@Api(value = "Gestão de pautas")
@AllArgsConstructor
public class Pauta {

    private final Logger logger = LoggerFactory.getLogger(Pauta.class);
    private final String TOPIC = "votacao_paulta_finalizada";
    KafkaTemplate<String, Mensagem> kafkaTemplate;
    PautaServico pautaServico;

    @GetMapping
    @ApiOperation(value = "Retorna uma lista de todas as pautas.")
    public ResponseEntity<PautaDTO> getPautas() {
        logger.info("Buscando pautas.");
        pautaServico.analisar("71095675168");
        kafkaTemplate.send(TOPIC,new Mensagem(1L,"foi finalizado"));
        return ResponseEntity.ok(PautaDTO.builder().id(1L).build());
    }

    @GetMapping
    @ApiOperation(value = "Retorna uma lista de todas as pautas.")
    public ResponseEntity<List<PautaDTO>> getPautas() {
        logger.info("Buscando todas as pautas.");
        return pautaService.getPautas()
                .map(pauta -> objectMapper.convertValue(pauta, PautaResponse.class))
                .doOnComplete(() -> logger.info("Retornando lista de pautas."));
    }

    @GetMapping("/{idPauta}")
    @ApiOperation(value = "Retorna uma pauta especifica.", response = PautaResponse.class)
    public ResponseEntity<PautaDTO> getPauta(@PathVariable("idPauta") String idPauta) {
        logger.info("Bucando pauta {}.", idPauta);
        return pautaService.getPauta(idPauta)
                .map(pauta -> objectMapper.convertValue(pauta, PautaResponse.class))
                .doOnSuccess(it -> logger.info("Retornando pauta especifica."));
    }

    @PostMapping
    @ApiOperation(value = "Cria uma nova pauta.", response = PautaResponse.class)
    public Mono<ResponseEntity<PautaResponse>> criarPauta(@RequestBody @Valid PautaRequest pautaRequest) {
        logger.info("Chamada para criar pauta: {}.", pautaRequest);
        return pautaService
                .criarPauta(objectMapper.convertValue(pautaRequest, Pauta.class))
                .map(pauta -> objectMapper.convertValue(pauta, PautaResponse.class))
                .map(pautaResponse -> ResponseEntity.status(HttpStatus.CREATED).body(pautaResponse))
                .doOnSuccess(pautaResponse -> logger.info("Pauta criada com sucesso!"));
    }



    @PostMapping("/{idPauta}/votar")
    @ApiOperation(value = "Realiza o voto na pauta especificada.")
    public Mono<ResponseEntity> votar(@PathVariable("idPauta") String idPauta,
                                      @RequestBody @Valid VotoRequest votoRequest) {
        logger.info("Pauta {} adicionando voto {}.", idPauta, votoRequest);
        return pautaService.votar(idPauta, objectMapper.convertValue(votoRequest, Voto.class))
                .map(it -> (ResponseEntity) ResponseEntity.ok().build())
                .doOnSuccess(it -> logger.info("Voto adicionado com sucesso."));
    }


}
