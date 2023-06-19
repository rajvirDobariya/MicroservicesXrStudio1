package com.lcwd.hotel.exception;


/**
 * 
 * This class use to throw User exception
 * 
 * @author Ravi
 */
public class HotelException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	String error;

	public HotelException(String error) {

		this.error = error;

	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
