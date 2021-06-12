package miranda.ewerton.zup.casadocodigo.autor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ExtendWith({SpringExtension.class})
public class AutorRepositorioTests {

    @Autowired
    private AutorRepositorio autorRepositorio;

    private Autor autor0 = new Autor("Tomas" ,"tomas@email.com","desc");
    private Autor autor1 = new Autor("Carlos" ,"carlos@email.com","desc");
    private Autor autor2 = new Autor("Mario" ,"mario@email.com","desc");
    @Test
    public void deve_salvar_um_novo_autor(){
     autorRepositorio.save(autor0);
     List<Autor>list =
             StreamSupport.stream(autorRepositorio.findAll().spliterator(),false)
                                                           .collect(Collectors.toList());
     Integer countSize = list.size();
     assertEquals(1,countSize);
    }
    @Test
    public void deve_encontrar_um_autor_por_nome(){
      autorRepositorio.save(autor0);
      autorRepositorio.save(autor2);
      autorRepositorio.save(autor1);

      var feliz = autorRepositorio.findByNome("Mario");

      assertTrue(feliz.isPresent());
      assertFalse(feliz.isEmpty());

    }



}
