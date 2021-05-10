package miranda.ewerton.zup.casadocodigo.livro;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepositorio extends CrudRepository<Livro, Long>{

}
