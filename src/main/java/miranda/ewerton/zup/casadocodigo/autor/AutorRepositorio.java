package miranda.ewerton.zup.casadocodigo.autor;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepositorio extends CrudRepository<Autor ,Long> {
}
