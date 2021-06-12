package miranda.ewerton.zup.casadocodigo.autor;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AutorRepositorio extends CrudRepository<Autor ,Long> {

    public Optional<Autor> findByNome(String nome);
}
