package br.com.sicredi.entrevista.assembleia.client;

import feign.Param;
import feign.RequestLine;

public interface CPFClient {

    @RequestLine("GET /{cpf}")
    CPFClientDTO validarCpf(@Param("cpf") String cpf);

}
