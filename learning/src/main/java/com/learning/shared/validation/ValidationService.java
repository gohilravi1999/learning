package com.learning.shared.validation;

import javax.validation.ConstraintViolationException;

public interface ValidationService {

	public <T> boolean validateBean(T requestBean) throws ConstraintViolationException;
}
