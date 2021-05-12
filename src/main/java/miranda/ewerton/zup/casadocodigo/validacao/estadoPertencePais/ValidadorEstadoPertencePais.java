package miranda.ewerton.zup.casadocodigo.validacao.estadoPertencePais;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapperImpl;

public class ValidadorEstadoPertencePais implements ConstraintValidator<EstadoPertencePais, Object>{
	
	@PersistenceContext
	private EntityManager em ;

	private String campoIdEstado ;
	private String campoIdPais ;
	private Class<?> classe ;
	
	
	@Override
	public void initialize(EstadoPertencePais anotacao) {
	 campoIdEstado = anotacao.campoIdEstado();
	 campoIdPais = anotacao.campoIdPais() ;
	 classe = anotacao.classeDeDominio();
		
	}
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {

		Query query =em.createQuery 
		("SELECT 1 FROM " + classe.getSimpleName()+ " e  WHERE e.id = :idEstado AND e.pais.id = :idPais ");		
		
		Long estadoId =(Long) new BeanWrapperImpl(value).getPropertyValue(campoIdEstado);
		Long paisId =(Long) new BeanWrapperImpl(value).getPropertyValue(campoIdPais);
		query.setParameter("idEstado", estadoId);
		query.setParameter("idPais", paisId);
				
		return !query.getResultList().isEmpty();
	}
	
	

	
	
	
}
