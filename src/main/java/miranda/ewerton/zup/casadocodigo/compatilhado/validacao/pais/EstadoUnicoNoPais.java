package miranda.ewerton.zup.casadocodigo.compatilhado.validacao.pais;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = {EstadoUnicoNoPaisValidator.class})
public @interface EstadoUnicoNoPais {
    String message() default "Apenas um Estado com mesmo nome por pais.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String campoNome();
    String campoId();
    Class<?> classeDeDominio();
}
