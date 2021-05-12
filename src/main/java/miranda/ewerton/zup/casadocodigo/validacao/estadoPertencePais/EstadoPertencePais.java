package miranda.ewerton.zup.casadocodigo.validacao.estadoPertencePais;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {ValidadorEstadoPertencePais.class})
public @interface EstadoPertencePais {
	String message() default "Estado não pertence ao Pais." ;
    Class<?> []groups() default {};
    Class<? extends Payload>[] payload() default {};
    String campoIdPais ();
    String campoIdEstado ();
    Class<?> classeDeDominio() ;
}
