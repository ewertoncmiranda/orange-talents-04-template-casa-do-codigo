package miranda.ewerton.zup.casadocodigo.autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/autor")
@RestController
public class AutorController {

    @Autowired
    AutorRepositorio repository;

    @PostMapping
    public ResponseEntity<String> salvarNovoAutor(@RequestBody @Valid AutorRequester autor ){
       return ResponseEntity.ok().body(repository.save(autor.toModel()).toString()) ;
    }
}
