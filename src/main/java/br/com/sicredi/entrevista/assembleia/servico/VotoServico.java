package br.com.sicredi.entrevista.assembleia.teste.servico;

import br.com.sicredi.entrevista.assembleia.teste.client.CPFClient;
import br.com.sicredi.entrevista.assembleia.teste.dominio.Voto;
import br.com.sicredi.entrevista.assembleia.teste.excecao.NegocioException;
import br.com.sicredi.entrevista.assembleia.teste.excecao.ResourceNotFoundException;
import br.com.sicredi.entrevista.assembleia.teste.repositorio.VotoRepositorio;
import br.com.sicredi.entrevista.assembleia.teste.servico.conversor.VotoConverter;
import br.com.sicredi.entrevista.assembleia.teste.servico.dto.ResultadoDTO;
import br.com.sicredi.entrevista.assembleia.teste.servico.dto.VotoDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class VotoServico {

    private VotoRepositorio votoRepositorio;
    private VotoConverter votoConverter;
    private CPFClient cpfClient;
    private SessaoServico sessaoServico;

    @Transactional
    public VotoDTO criar(VotoDTO votoDTO){
        //associadoPossuiCpfValido(votoDTO);
        associadoJaVotou(votoDTO);
        existeSessaAberta(votoDTO);
        sessaoServico.sessaoExiste(votoDTO.getSessaoId());

        Voto voto = votoConverter.toEntity(votoDTO);
        votoRepositorio.save(voto);
        return votoConverter.toDto(voto,votoDTO.getPautaId());
    }

    public List<ResultadoDTO> buscarVotosDePauta(Long pautaId){
        List<ResultadoDTO> resultado = votoRepositorio.buscarVotosDePauta(pautaId);


        return resultado;

    }


    private void associadoPossuiCpfValido(VotoDTO votoDTO)  {
        if(!cpfClient.validarCpf(votoDTO.getCpf()).isValido()){
            throw new ResourceNotFoundException("Associado não possui cpf válido.");
        }
    }

    private void associadoJaVotou(VotoDTO votoDTO){
        if(votoRepositorio.existeVoto(votoDTO.getCpf(),votoDTO.getSessaoId())){
            throw new NegocioException("Voto não pode ser computado, associado já votou para essa pauta.");
        }
    }

    private void existeSessaAberta(VotoDTO votoDTO){
        if(!sessaoServico.existeSessaoAberta(votoDTO.getSessaoId())){
            throw new NegocioException("Voto não pode ser computado, sessão já foi finalizada.");
        }
    }


}
