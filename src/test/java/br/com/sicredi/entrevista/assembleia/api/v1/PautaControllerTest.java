package br.com.sicredi.entrevista.assembleia.service;

import br.com.sicredi.entrevista.assembleia.dominio.Pauta;
import br.com.sicredi.entrevista.assembleia.repositorio.PautaRepositorio;
import br.com.sicredi.entrevista.assembleia.servico.PautaServico;
import br.com.sicredi.entrevista.assembleia.servico.conversor.PautaConverter;
import br.com.sicredi.entrevista.assembleia.servico.dto.PautaDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class PautaServicoTest {

    @InjectMocks
    private PautaServico pautaServico;
    @Mock
    private PautaConverter pautaConverter;
    @Mock
    private PautaRepositorio pautaRepositorio;
    @Captor
    private ArgumentCaptor<Pauta> pautaArgumentCaptor;

    @Test
    public void criar(){
        PautaDTO pautaDTO = PautaDTO.builder().id(1L).nome("pauta_x").build();
        pautaServico.criar(pautaDTO);
        verify(pautaRepositorio, times(1)).save(pautaArgumentCaptor.capture());
        assertEquals(pautaDTO, pautaArgumentCaptor.getValue());

    }


}
