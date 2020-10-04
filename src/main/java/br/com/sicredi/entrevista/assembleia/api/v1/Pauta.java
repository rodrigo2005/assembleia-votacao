package br.com.sicredi.entrevista.assembleia.api.v1;

import br.com.sicredi.entrevista.assembleia.dto.PautaDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1/pauta")
@Api(value = "Gestão de pautas")
public class Pauta {

    private final Logger logger = LoggerFactory.getLogger(Pauta.class);


    @GetMapping
    @ApiOperation(value = "Retorna uma lista de todas as pautas.", response = PautaDTO.class)
    public ResponseEntity<PautaDTO> getPautas() {
        logger.info("Buscando pautas.");
        return ResponseEntity.ok(PautaDTO.builder().id(1L).build());
    }


}
