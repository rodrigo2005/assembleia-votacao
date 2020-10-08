package br.com.sicredi.entrevista.assembleia.repositorio;

import br.com.sicredi.entrevista.assembleia.dominio.Pauta;
import br.com.sicredi.entrevista.assembleia.dominio.Sessao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PautaRepositorio extends JpaRepository<Pauta, Long> {

}
