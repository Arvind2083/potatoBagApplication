/**
 * 
 */
package com.potatoBag.util.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Arvind
 *
 */
public class RangValidatorImpl implements ConstraintValidator<RangValidator, Object>{
	
	final static public String message= "The {message} of Potato must be between {min} and {max}";
	
	private long min;
	private long max;

	@Override
	public void initialize(RangValidator constraintAnnotation) {
		this.min = constraintAnnotation.min();
		this.max = constraintAnnotation.max();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		
		 if(value instanceof Integer ){
			 int count = Integer.valueOf((Integer)value);	
			 if(value == null || (count < min || count > max)){
				 return false;
			 }
		 }
		 if(value instanceof Double ){
			 Double price = Double.valueOf((Double)value);	
			 if(value == null || (price < min || price > max)){
				 return false;
			 }
		 }
		return true;
		
	}
}
