package com.pkrm.exception;

public class ValidationFailedException extends RuntimeException {

	private static final long serialVersionUID = 6842014507562872893L;

	String errorMsg;

	public ValidationFailedException() {
		super();
	}

	public ValidationFailedException(String errorMsg) {
		super(errorMsg);
		this.errorMsg = errorMsg;
	}

}
