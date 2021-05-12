package miranda.ewerton.zup.casadocodigo.estado;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/estado")
@RestController
public class NovoEstadoController {
	
	@PersistenceContext
	private EntityManager em ;
	
	@PostMapping
	@Transactional
	public ResponseEntity<String> cadastroNovoEstado(@RequestBody @Valid NovoEstadoRequester novoEstado){
		Estado estado = novoEstado.toModel(em);
		em.persist(estado);
		return ResponseEntity.ok(estado.toString());
	}

}
