package miranda.ewerton.zup.casadocodigo.autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RequestMapping("/autor")
@RestController
public class AutorController {

    @Autowired
    AutorController(AutorRepositorio repositorio){
        this.repositorio = repositorio;
    }

   final AutorRepositorio repositorio;

    @PostMapping
    public ResponseEntity<AutorResponse> salvarNovoAutor(@RequestBody @Valid  NovoAutorRequester autor){
      var novoAutor = autor.toModel();
      novoAutor = repositorio.save(novoAutor);
      var response  = new AutorResponse( novoAutor.getNome());

      return ResponseEntity.ok().build() ;
    }
}
