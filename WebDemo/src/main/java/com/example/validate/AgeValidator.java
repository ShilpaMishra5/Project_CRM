package com.example.validate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<Age, Integer> {

	int max;
	int min;

	@Override
	public void initialize(Age age) {

		this.max = age.max();
		this.min = age.min();

	}

	@Override
	public boolean isValid(Integer age, ConstraintValidatorContext context) {

		if (age > max || age < min)
			return false;

		return true;

	}

}
