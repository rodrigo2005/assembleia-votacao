package br.com.sicredi.entrevista.assembleia.api.v1;

import br.com.sicredi.entrevista.assembleia.api.v1.converter.SessaoRequestConverter;
import br.com.sicredi.entrevista.assembleia.api.v1.request.SessaoRequest;
import br.com.sicredi.entrevista.assembleia.servico.SessaoServico;
import br.com.sicredi.entrevista.assembleia.servico.dto.SessaoDTO;
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
@RequestMapping("/v1/sessao")
@Api(value = "Gestão de sessões de votação")
@AllArgsConstructor
public class SessaoController {

    private final Logger logger = LoggerFactory.getLogger(SessaoController.class);
    private SessaoServico sessaoServico;
    private SessaoRequestConverter sessaoRequestConverter;

    @PostMapping("/iniciar-sessao")
    @ApiOperation(value = "Inicia uma sessão na pauta informada.")
    public ResponseEntity<SessaoDTO> iniciarSessao(@Valid @RequestBody SessaoRequest sessaoRequest) {
        logger.info("Sessão {} tentativa de abertura de sessão {}.",sessaoRequest);
        return new ResponseEntity<SessaoDTO>(sessaoServico.criar(sessaoRequestConverter.toDTO(sessaoRequest)), HttpStatus.CREATED);
    }



}
