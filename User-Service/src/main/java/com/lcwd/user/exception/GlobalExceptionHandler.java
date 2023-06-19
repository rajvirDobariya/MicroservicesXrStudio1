package com.lcwd.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.lcwd.user.apierror.ApiError;
import com.lcwd.user.utils.Messages;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFondException.class)
	public ResponseEntity<Object> MethodArgsNotValidExceptionHandler(ResourceNotFondException ex) {
	
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
		apiError.setMessage(ex.getMessage());
		return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
	}

	/**
	 * This method is UserException handler
	 **/
	@ExceptionHandler(UserException.class)
	protected ResponseEntity<Object> userExceptionHandler(UserException ex) {
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
		apiError.setMessage(ex.getError());
		apiError.setDescription(Messages.ENTER_VALID_FIELD_TRY_AGAIN);
		return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
	}

}
