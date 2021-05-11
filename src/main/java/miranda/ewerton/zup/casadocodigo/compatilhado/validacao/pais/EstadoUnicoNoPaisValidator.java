package miranda.ewerton.zup.casadocodigo.compatilhado.validacao.pais;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapperImpl;

public class EstadoUnicoNoPaisValidator implements ConstraintValidator<EstadoUnicoNoPais, Object> {

	@PersistenceContext
	private EntityManager em;

	private String campoId;
	private String campoNome;
	private Class<?> classe;

	@Override
	public void initialize(EstadoUnicoNoPais anotacao) {
		campoId = anotacao.campoId();
		campoNome = anotacao.campoNome();
		classe = anotacao.classeDeDominio();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {

		String jpql = "SELECT 1 FROM " + classe.getName() + " c WHERE " + campoNome
				+ " =:nome AND c.pais.id = :idPais";
		
		String nome = (String) new BeanWrapperImpl(value).getPropertyValue(campoNome);
		Long id = (Long) new BeanWrapperImpl(value).getPropertyValue(campoId);
		
		Query query = em.createQuery(jpql);
		query.setParameter("nome",campoNome);
		
		query.setParameter("idPais" , id);
		
		return query.getResultList().isEmpty();
	}

}
