package miranda.ewerton.zup.casadocodigo.validacao.existid;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {ExistIdValidator.class})
public @interface ExistsId {
	String message() default "Id não existe na base de dados" ;
	Class<?> []groups() default {};
    Class<? extends Payload>[] payload() default {};
    String nomeDoCampo ();
    Class<?> classeDeDominio() ;
	

}
