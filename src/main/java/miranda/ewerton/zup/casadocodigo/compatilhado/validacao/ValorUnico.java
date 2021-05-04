package miranda.ewerton.zup.casadocodigo.compatilhado.validacao;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {ValidadorValorUnico.class})
public @interface ValorUnico {
    String message() default "Erro ao inserir campo! Esse valor deve ser unico! " ;
    Class<?> []groups() default {};
    Class<? extends Payload>[] payload() default {};
    String nomeDoCampo ();
    Class<?> domainClass() ;
}
