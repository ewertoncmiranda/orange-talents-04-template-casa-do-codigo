package miranda.ewerton.zup.casadocodigo.cliente;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/cliente")
@RestController
public class NovoClienteController {

	@PersistenceContext
	private EntityManager em;

	@PostMapping
	@Transactional
	public ClienteResponse criarNovoCliente(@Valid @RequestBody NovoClienteRequester novoCliente) {
		
		Cliente cliente =novoCliente.toModel(em);
		em.persist(cliente);

		return new ClienteResponse(cliente);
	}

}
