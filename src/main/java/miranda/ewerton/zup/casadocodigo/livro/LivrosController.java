package miranda.ewerton.zup.casadocodigo.livro;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import miranda.ewerton.zup.casadocodigo.livro.dto.LivroDetalheResponse;
import miranda.ewerton.zup.casadocodigo.livro.dto.NovoLivroRequester;

@RestController
@RequestMapping("/livro")
public class LivrosController {

	@Autowired
	LivroRepositorio repositorio;

	@PersistenceContext
	EntityManager em;

	@PostMapping
	public ResponseEntity<String> novoLivro(@RequestBody @Valid NovoLivroRequester req) {
		return ResponseEntity.ok(repositorio.save(req.toModel(em)).toString());
	}

	@GetMapping
	public ResponseEntity<List<LivroDetalheResponse>> listarTodosOsLivros() {

		List<LivroDetalheResponse> listaDeLivros = new ArrayList<>();
		for (Livro livro : repositorio.findAll()) {
			listaDeLivros.add(new LivroDetalheResponse(livro));
		}
		return ResponseEntity.ok(listaDeLivros);
	}

}
