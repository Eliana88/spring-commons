package com.github.damianwajser.validator.constraint.gobal;

import com.github.damianwajser.validator.annotation.global.Max;
import com.github.damianwajser.validator.constraint.AbstractConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 */
public class MaxConstraint extends AbstractConstraint implements ConstraintValidator<Max, Object> {

	long max;

	@Override
	public void initialize(Max field) {
		super.excludes = field.excludes();
		this.max = field.max();
	}

	@Override
	public boolean hasError(Object field, ConstraintValidatorContext cxt) {
		boolean hasError = true;
		if (field != null && Number.class.isAssignableFrom(field.getClass())) {
			long fieldMax = ((Number) field).longValue();
			hasError = fieldMax > max;
		}
		return hasError;
	}

}
