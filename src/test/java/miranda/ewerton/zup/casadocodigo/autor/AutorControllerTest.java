package miranda.ewerton.zup.casadocodigo.autor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AutorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper jsonMapper;


   @Test
    void  teste_Deve_Criar_Um_Novo_Autor_E_Devolver_Status_200() throws Exception {

    var autorRequester = new NovoAutorRequester("tomas@caminhofeliz.com" ,"Testador da Madrugada" ,"descricao correta") ;
    String json = jsonMapper.writeValueAsString(autorRequester);

    this.mockMvc.perform(
            MockMvcRequestBuilders.post("/autor")
                                  .contentType(MediaType.APPLICATION_JSON)
                                  .content(json))
            .andExpect(status().is(200));
    }

    //TESTES DE VALIDADORES
    @Test
    void  deve_lancar_excessao_email_errado_validators() throws Exception {

        var autorRequester = new NovoAutorRequester("emailerrado_semo_arroba" ,"Testador da Madrugada" ,"descricao correta") ;
        String json = jsonMapper.writeValueAsString(autorRequester);

        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/autor")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().is4xxClientError());
    }

    @Test
    void deve_lancar_excessao_nome_vazio_validators () throws Exception {

        var autorRequester = new NovoAutorRequester("email@caminhozuado.com.nome" ,"" ,"descricao correta") ;
        String json = jsonMapper.writeValueAsString(autorRequester);

        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/autor")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().is4xxClientError());
    }

    @Test
    void deve_lancar_excessao_mais_400_caracteres_validators () throws Exception {

       String maisDe400Chars ="";

        var autorRequester = new NovoAutorRequester("email@caminhozuado.com.nome" ,"" ,this.maisDe400Chars()) ;
        String json = jsonMapper.writeValueAsString(autorRequester);

        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/autor")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().is4xxClientError());
    }
    @Test
    void deve_lancar_excessao_requisição_body_vazio () throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/autor")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }


  public String maisDe400Chars(){
      return "1914 translation by H. Rackham"+
              "But I must explain to you how all this mistaken idea of denouncing pleasure " +
              "and praising pain was born and I will give you a complete account of the system, and " +
              "expound the actual teachings of the great explorer of the truth, the master-builder of" +
              " human happiness. No one rejects, dislikes, or avoids pleasure itself, because it is " +
              "that are extremely painful. Nor again is there anyone who loves or pursues or desires to obtain " +
              "pain of itself, because it is pain, but because occasionally circumstances occur in which toil " +
              " or one who avoids a pain that produces no resultant pleasure?" ;


  }

}