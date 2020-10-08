package br.com.sicredi.entrevista.assembleia.api.v1;

import br.com.sicredi.entrevista.assembleia.api.v1.converter.PautaRequestConverter;
import br.com.sicredi.entrevista.assembleia.api.v1.request.PautaRequest;
import br.com.sicredi.entrevista.assembleia.servico.PautaServico;
import br.com.sicredi.entrevista.assembleia.servico.dto.PautaDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/v1/pauta")
@Api(value = "Gestão de pautas")
@AllArgsConstructor
public class PautaController {

    private final Logger logger = LoggerFactory.getLogger(PautaController.class);
    private PautaServico pautaServico;
    private PautaRequestConverter pautaRequestConverter;

    @PostMapping
    @ApiOperation(value = "Cria uma pauta")
    public ResponseEntity<PautaDTO> criarPauta(@RequestBody @Valid PautaRequest pautaRequest) {
        logger.info("Criando pauta: {}.", pautaRequest);
        return new ResponseEntity<PautaDTO>( pautaServico
                .criar(pautaRequestConverter.toDTO(pautaRequest)), HttpStatus.CREATED);
    }


    @GetMapping
    @ApiOperation(value = "Retorna uma lista de todas as pautas")
    public ResponseEntity<List<PautaDTO>> getPautas() {
        logger.info("Buscando pautas.");
        return ResponseEntity.ok(pautaServico.buscarPautas());
    }


    @GetMapping("/{idPauta}")
    @ApiOperation(value = "Retorna uma pauta baseado no ID da pauta")
    public ResponseEntity<PautaDTO> getPauta(@PathVariable("idPauta") Long idPauta) {
        logger.info("Bucando pauta com ID: {}.", idPauta);
        return ResponseEntity.ok(pautaServico.buscarPautaPorId(idPauta));
    }

}
