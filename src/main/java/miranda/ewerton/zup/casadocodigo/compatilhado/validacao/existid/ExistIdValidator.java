package miranda.ewerton.zup.casadocodigo.compatilhado.validacao.existid;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ExistIdValidator implements ConstraintValidator<ExistsId, Object> {

	@PersistenceContext
	private EntityManager entityManager;

	private String campoAValidar;
	private Class<?> classe;

	@Override
	public void initialize(ExistsId anotacao) {
		campoAValidar = anotacao.nomeDoCampo().toLowerCase();
		classe = anotacao.classeDeDominio();
	}			
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		Query query = entityManager.createQuery( "SELECT 1 FROM "+classe.getName()+" WHERE "+campoAValidar+" =:value");
		query.setParameter("value", value);
		
		List<?> list = query.getResultList();
		return !list.isEmpty();
	}

}
