package br.com.sicredi.entrevista.assembleia.api.v1;

import br.com.sicredi.entrevista.assembleia.api.v1.converter.VotoRequestConverter;
import br.com.sicredi.entrevista.assembleia.api.v1.request.VotoRequest;
import br.com.sicredi.entrevista.assembleia.servico.VotoServico;
import br.com.sicredi.entrevista.assembleia.servico.dto.VotoDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/voto")
@Api(value = "Gestão de votos de uma sessão")
@AllArgsConstructor
public class VotoController {

    private final Logger logger = LoggerFactory.getLogger(VotoController.class);
    private VotoRequestConverter votoRequestConverter;
    private VotoServico votoServico;

    @PostMapping("/votar")
    @ApiOperation(value = "Realiza o voto na pauta especificada.")
    public ResponseEntity<VotoDTO> votar(@RequestBody @Valid VotoRequest votoRequest) {
        logger.info("Adicionando voto {}.", votoRequest);
        return new ResponseEntity<VotoDTO>(votoServico.criar(votoRequestConverter.toDTO(votoRequest)), HttpStatus.CREATED);
    }

}
