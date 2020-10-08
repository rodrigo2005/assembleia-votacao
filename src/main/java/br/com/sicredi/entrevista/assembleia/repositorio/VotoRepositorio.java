package br.com.sicredi.entrevista.assembleia.repositorio;

import br.com.sicredi.entrevista.assembleia.dominio.Voto;
import br.com.sicredi.entrevista.assembleia.servico.dto.ResultadoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VotoRepositorio extends JpaRepository<Voto, Long> {


    @Query("select COUNT(v) > 0 from Voto v where v.cpf = ?1 and v.sessao.id = ?2")
    boolean existeVoto(String cpf, Long pautaId);

    @Query("SELECT new br.com.sicredi.entrevista.assembleia.servico.dto.ResultadoDTO(v.opcao, COUNT(v.opcao)) "
            + "FROM Voto v where v.sessao.pauta.id = ?1 GROUP BY v.opcao ORDER BY v.opcao DESC")
    List<ResultadoDTO> buscarVotosDePauta(Long pautaId);


}
