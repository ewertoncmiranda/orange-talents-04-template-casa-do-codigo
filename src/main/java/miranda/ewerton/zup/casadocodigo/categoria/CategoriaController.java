package miranda.ewerton.zup.casadocodigo.categoria;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	CategoriaRepositorio repositorio;
	
	@PostMapping
	public ResponseEntity<String> cadastrarNovaCategoria(@RequestBody @Valid CategoriaRequester requester){
	 return ResponseEntity.ok().body(repositorio.save(requester.toModel()).toString());	
	}
	
	

}
