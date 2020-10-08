package br.com.sicredi.entrevista.assembleia.repositorio;

import br.com.sicredi.entrevista.assembleia.dominio.Voto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VotoRepositorio extends JpaRepository<Voto, Long> {


    @Query("select COUNT(v) > 0 from Voto v where v.cpf = ?1 and v.sessao.id = ?2")
    boolean existeVoto(String cpf, Long pautaId);


}
