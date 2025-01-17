package miranda.ewerton.zup.casadocodigo.compatilhado.validacao.valorunico;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidadorValorUnico implements ConstraintValidator<ValorUnico , Object> {

    @PersistenceContext
    EntityManager entityManager;

    private String campoAValidar ;
    private Class<?> classe ;

    @Override
    public void initialize(ValorUnico anotacao) {
        campoAValidar = anotacao.nomeDoCampo().toLowerCase();
        classe = anotacao.classeDeDominio();
    }

    @Override
    public boolean isValid(Object valor, ConstraintValidatorContext context) {
        Query query = entityManager.createQuery
               ("SELECT 1 FROM "+ classe.getName()+" WHERE "+campoAValidar+" = :valor ");
        query.setParameter("valor", valor);
        List<?> queryResultList = query.getResultList();
        
        return queryResultList.isEmpty();
    }
}
