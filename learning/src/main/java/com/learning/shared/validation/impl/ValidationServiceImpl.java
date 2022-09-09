package com.learning.shared.validation.impl;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.shared.validation.ValidationService;

@Service
public class ValidationServiceImpl implements ValidationService{
	
	@Autowired
	private Validator validator;

	@Override
	public <T> boolean validateBean(T requestBean) throws ConstraintViolationException {
		Set<ConstraintViolation<T>> violations = validator.validate(requestBean);

		if (!violations.isEmpty()) {
			StringBuilder sb = new StringBuilder();
			for (ConstraintViolation<T> constraintViolation : violations) {
				sb.append(constraintViolation.getMessage());
			}
			throw new ConstraintViolationException(sb.toString(), violations);
		}
		return true;
	}

}
