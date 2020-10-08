package br.com.sicredi.entrevista.assembleia.excecao;

import org.springframework.http.HttpStatus;


public class AssociadoNaoValidoException extends AbstractThrowableProblem {

    private static final long serialVersionUID = 1L;

    public AssociadoNaoValidoException() {
        super(ErrorConstants.EMAIL_NOT_FOUND_TYPE, "Email address not registered", Status);
    }
}
