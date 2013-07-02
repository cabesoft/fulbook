package com.cabesoft.service.exception;

import java.util.HashMap;
import java.util.Map;

public class ValidationException extends Exception {
	private static final long serialVersionUID = 1L;

	private Map<String, String> errors = new HashMap<String, String>();

	public ValidationException(Map<String, String> errors) {
		super();
		this.errors = errors;
	}

	public Map<String, String> getErrors() {
		return this.errors;
	}

	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}

	@Override
	public String toString() {
		return "ValidationException " + this.errors.values();
	}

}
