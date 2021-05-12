package miranda.ewerton.zup.casadocodigo.validacao.estadounicoporpais;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapperImpl;

public class ValidadorEstadoUnicoPorPais implements ConstraintValidator<EstadoUnicoPorPais, Object> {

	@PersistenceContext
	EntityManager em;

	private String campoId;
	private String campoNome;
	private Class<?> classe;

	@Override
	public void initialize(EstadoUnicoPorPais anotacao) {
		campoId = anotacao.campoIdPais();
		classe = anotacao.classeDeDominio();
		campoNome = anotacao.campoNome();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		Query query = em.createQuery(
				"SELECT 1 FROM " + classe.getName() + " c WHERE "+campoNome+" =:nome AND c.pais.id =:idPais");
		
		
		String nome= (String) new BeanWrapperImpl(value).getPropertyValue(campoNome);
		query.setParameter("nome", nome);
		
		Long idPais = (Long) new BeanWrapperImpl(value).getPropertyValue(campoId);
		query.setParameter("idPais", idPais);
		return query.getResultList().isEmpty();

	}

}
