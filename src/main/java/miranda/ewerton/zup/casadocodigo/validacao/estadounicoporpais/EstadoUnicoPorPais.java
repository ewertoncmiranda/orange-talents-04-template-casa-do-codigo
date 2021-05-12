package miranda.ewerton.zup.casadocodigo.validacao.estadounicoporpais;

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
@Constraint(validatedBy = {ValidadorEstadoUnicoPorPais.class})
public @interface EstadoUnicoPorPais {
		String message() default "Não é possivel cadastrar mais de um estado com mesmo nome por Pais." ;
	    Class<?> []groups() default {};
	    Class<? extends Payload>[] payload() default {};
	    String campoIdPais ();
	    String campoNome ();
	    Class<?> classeDeDominio() ;

}
