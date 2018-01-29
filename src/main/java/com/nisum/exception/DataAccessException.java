package com.nisum.exception;

public class DataAccessException extends RuntimeException {

	private static final long serialVersionUID = 4061587773153993377L;
	
	public DataAccessException(String message) {
		super(message);
	}
	
	public DataAccessException(String message, Throwable th) {
		super(message, th);
	}

}
