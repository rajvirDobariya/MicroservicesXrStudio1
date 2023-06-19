package com.lcwd.rating.exception;

/**
 * 
 * This class use to throw User exception
 * 
 * @author Ravi
 */
public class RatingException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	String error;

	public RatingException(String error) {

		this.error = error;

	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
