package br.com.sicredi.entrevista.assembleia.api.v1;

import br.com.sicredi.entrevista.assembleia.api.v1.request.VotoRequestTest;
import br.com.sicredi.entrevista.assembleia.enun.OpcaoVoto;
import br.com.sicredi.entrevista.assembleia.servico.dto.VotoDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TestVotoController {

    @Autowired
    public WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void criarComSucesso() throws Exception {
        String url = "/v1/voto/votar";
        VotoRequestTest votoRequest = VotoRequestTest.builder().cpf("14412497100").opcao(OpcaoVoto.SIM).sessaoId(1L).build();
        VotoDTO votoDTO = VotoDTO.builder()
                .cpf("14412497100")
                .opcao(OpcaoVoto.SIM)
                .sessaoId(1L)
                .id(1L)
                .build();

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        String votoRequestJson = mapper.writeValueAsString(votoRequest);
        String votoDTOJson =  mapper.writeValueAsString(votoDTO);

        this.mockMvc.perform(post(url)
                .content(votoRequestJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().json(votoDTOJson))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test()
    public void criarSegundoVotoMesmoAssociado() throws Exception {
        String url = "/v1/voto/votar";
        VotoRequestTest votoRequest = VotoRequestTest.builder().cpf("14412497100").opcao(OpcaoVoto.NAO).sessaoId(1L).build();
        VotoDTO votoDTO = VotoDTO.builder()
                .cpf("14412497100")
                .opcao(OpcaoVoto.NAO)
                .sessaoId(1L)
                .id(2L)
                .pautaId(1L)
                .build();

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        String votoRequestJson = mapper.writeValueAsString(votoRequest);
        String votoDTOJson =  mapper.writeValueAsString(votoDTO);

        this.mockMvc.perform(post(url)
                .content(votoRequestJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andDo(MockMvcResultHandlers.print());
    }

//
//    @Test
//    public void criarComValidacaoObrigatoriaDeCampo() throws Exception {
//        String url = "/v1/pauta";
//        this.mockMvc.perform(post(url)
//                .content("{}")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isBadRequest())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    public void buscarTodos() throws Exception {
//        String url = "/v1/pauta";
//        this.mockMvc.perform(get(url)
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(1)))
//                .andExpect(jsonPath("$[0].nome", is("px")));
//    }
//
//    @Test
//    public void buscarPorId() throws Exception {
//        String url = "/v1/pauta/1";
//        this.mockMvc.perform(get(url)
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("id",equalTo(1)))
//                .andExpect(jsonPath("nome",equalTo("px")));
//
//    }
}
