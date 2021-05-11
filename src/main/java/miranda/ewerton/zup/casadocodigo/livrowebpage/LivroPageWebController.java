package miranda.ewerton.zup.casadocodigo.livrowebpage;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import miranda.ewerton.zup.casadocodigo.livro.Livro;

@RequestMapping("/produto")
@RestController
public class LivroPageWebController {

	@PersistenceContext
	private EntityManager em;

	@GetMapping("/{id}")
	public ResponseEntity<LivroWebPageResponse> buscarLivroPorId(@PathVariable Long id) {
		Livro livro = em.find(Livro.class, id);
		if (livro == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} else {
			return ResponseEntity.ok(new LivroWebPageResponse(livro));
		}
	}

}
