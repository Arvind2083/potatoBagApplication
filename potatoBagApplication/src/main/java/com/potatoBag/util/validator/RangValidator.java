/**
 * 
 */
package com.potatoBag.util.validator;

import com.potatoBag.util.validator.RangValidatorImpl;
import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author Arvind
 *
 */
@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy=RangValidatorImpl.class)
public @interface RangValidator {

	int min() default 0;
	int max() default Integer.MAX_VALUE;
	
	String message() default RangValidatorImpl.message;
	
	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
