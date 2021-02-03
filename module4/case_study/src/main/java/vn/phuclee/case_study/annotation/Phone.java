package vn.phuclee.case_study.annotation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PhoneValid.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Phone {
    String message() default "Please enter the correct format 090xxxxxxx , Thanks";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
