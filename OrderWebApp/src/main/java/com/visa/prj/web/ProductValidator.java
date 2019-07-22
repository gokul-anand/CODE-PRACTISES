package com.visa.prj.web;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.visa.prj.entity.Product;

@Component
public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(Product.class) ;
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name", "name.empty", "Name can't be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"category", "category.empty", "Category can't be empty");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"price", "price.empty", "Price can't be empty");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"count", "count.empty", "Count can't be empty");
		
		Product p = (Product) target;
		
		if (p.getPrice()<=0) {
			errors.rejectValue("price","prive.invalid","Price can't be negative");
		}
		
		
	}

}
