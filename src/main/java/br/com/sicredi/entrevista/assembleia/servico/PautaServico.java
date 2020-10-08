package br.com.sicredi.entrevista.assembleia.servico;

import br.com.sicredi.entrevista.assembleia.servico.conversor.PautaConverter;
import br.com.sicredi.entrevista.assembleia.dominio.Pauta;
import br.com.sicredi.entrevista.assembleia.servico.dto.PautaDTO;
import br.com.sicredi.entrevista.assembleia.repositorio.PautaRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class PautaServico {

    PautaRepositorio pautaRepositorio;
    PautaConverter pautaConverter;

    @Transactional
    public PautaDTO criar(PautaDTO pautaDTO){
        Pauta pauta = pautaConverter.toEntity(pautaDTO);
        pautaRepositorio.save(pauta);
        return pautaConverter.toDto(pauta);
    }

    public List<PautaDTO> buscarPautas(){
        return pautaConverter.toDto(pautaRepositorio.findAll());
    }

    public PautaDTO buscarPautaPorId(Long id){
        return pautaConverter.toDto(pautaRepositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Não existe pauta com o ID informado.")));
    }

    public void existePauta(Long pautaId){
        if(!pautaRepositorio.existsById(pautaId)){
            throw new IllegalArgumentException("Não existe pauta com o ID informado.");
        }
    }
}