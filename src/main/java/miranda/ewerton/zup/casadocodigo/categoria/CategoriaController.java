package miranda.ewerton.zup.casadocodigo.categoria;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/categoria")
@RestController
public class CategoriaController {
	
	@Autowired
	CategoriaRepositorio repositorio ;
	
	@PostMapping
	public String novaCategoria(@RequestBody @Valid NovaCategoriaRequester req) {
		return  repositorio.save(req.toModel()).toString();
	}

}
