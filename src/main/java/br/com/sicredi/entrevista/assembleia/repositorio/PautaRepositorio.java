package br.com.sicredi.entrevista.assembleia.teste.repositorio;

import br.com.sicredi.entrevista.assembleia.teste.dominio.Pauta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PautaRepositorio extends JpaRepository<Pauta, Long> {

}
