package miranda.ewerton.zup.casadocodigo.livro;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livro")
public class LivrosController {
	
	@Autowired
	LivroRepositorio repositorio ;
	
	@PersistenceContext
	EntityManager em;
	
	@PostMapping
	public String novoLivro(@RequestBody @Valid NovoLivroRequester req) {
	return repositorio.save(req.toModel(em)).toString();	
	}

}
