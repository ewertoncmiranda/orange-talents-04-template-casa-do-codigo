package miranda.ewerton.zup.casadocodigo.compatilhado.validacao.pais;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import miranda.ewerton.zup.casadocodigo.estado.Estado;
import miranda.ewerton.zup.casadocodigo.estado.NovoEstadoRequester;

@Component
public class EstadoUnicoPorPaisValidator implements Validator{

	@PersistenceContext
	private EntityManager em ;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return NovoEstadoRequester.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		//if(errors.hasErrors()) {	return ;	}		
		Estado estado = null;
		NovoEstadoRequester req = (NovoEstadoRequester) target ;
		
		try {
			estado = (Estado) em.createQuery(
					 "SELECT e FROM "+Estado.class.getSimpleName() + " e where e.pais.id = :idPais AND e.nome = :nome",Estado.class)
					.setParameter("idPais", req.getIdPais()).setParameter("nome", req.getNome()).getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
		}
		if(estado!=null) {
			errors.rejectValue("nome", null,"nome de estado cadastrado no pais " + estado.getPais().getNome());
		}
	}

}
