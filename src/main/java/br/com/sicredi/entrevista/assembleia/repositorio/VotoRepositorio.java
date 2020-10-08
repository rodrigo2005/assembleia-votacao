package br.com.sicredi.entrevista.assembleia.repositorio;

import br.com.sicredi.entrevista.assembleia.dominio.Pauta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PautaRepositorio extends JpaRepository<Pauta, Long> {

}
