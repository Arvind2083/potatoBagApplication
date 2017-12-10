/**
 * 
 */
package com.potatoBag.util.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
 
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @author Arvind
 *
 */
@Documented
@Constraint(validatedBy = {EnumSupplierValidator.class})
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface EnumSupplier {
	public abstract String message() default "Supplier Name is not correct.Valid supplier name from de coster,Owel,Patatas Ruben,Yunnan Spices";
    
    public abstract Class<?>[] groups() default {};
  
    public abstract Class<? extends Payload>[] payload() default {};
     
    public abstract Class<? extends java.lang.Enum<?>> enumClass();
     
    public abstract boolean ignoreCase() default false;
}