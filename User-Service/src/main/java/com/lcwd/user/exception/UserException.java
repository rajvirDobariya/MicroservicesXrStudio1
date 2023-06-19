package com.lcwd.user.exception;

/**
 * 
 * This class use to throw User exception
 * 
 * @author Ravi
 */
public class UserException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	String error;

	public UserException(String error) {

		this.error = error;

	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
