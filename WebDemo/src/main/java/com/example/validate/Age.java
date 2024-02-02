package com.example.validate;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = {AgeValidator.class })
public @interface Age {

	String message() default "Please provide between {min} to {max} years ";

	int max() default 50;

	int min() default 18;

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
