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
public class EnumSupplierValidator implements ConstraintValidator<EnumSupplier, String>{
	private EnumSupplier annotation;
	 
    @Override
    public void initialize(EnumSupplier annotation)
    {
        this.annotation = annotation;
    }
 
    @Override
    public boolean isValid(String valueForValidation, ConstraintValidatorContext constraintValidatorContext)
    {
        boolean result = false;
         
        Object[] enumValues = this.annotation.enumClass().getEnumConstants();
         
        if(enumValues != null)
        {
            for(Object enumValue:enumValues)
            {
                if(valueForValidation.equals(enumValue.toString()) 
                   || (this.annotation.ignoreCase() && valueForValidation.equalsIgnoreCase(enumValue.toString())))
                {
                    result = true; 
                    break;
                }
            }
        }
         
        return result;
    }
}
