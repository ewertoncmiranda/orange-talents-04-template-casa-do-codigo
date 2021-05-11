package miranda.ewerton.zup.casadocodigo.pais;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/pais")
@RestController
public class NovoPaisController {

	@Autowired
	private PaisRepositorio repositorio;

	@PostMapping
	public ResponseEntity<String> cadastrarNovoPais(@RequestBody @Valid NovoPaisRequester pais) {
		return ResponseEntity.ok(repositorio.save(pais.toModel()).toString());
	}

}
