package com.tka.exceptions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
		Map<String, String> errorMap = new HashMap<String, String>();
		List<FieldError> fieldErrors = ex.getFieldErrors();
		for (FieldError fieldError : fieldErrors) {
			errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		return errorMap;
	}

	@ExceptionHandler(ArithmeticException.class)
	public String divedeByZeroError(ArithmeticException ex) {
		return ex.getMessage();
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public String illegalArgumentException(IllegalArgumentException ex) {
		return ex.getMessage();
	}

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public String httpRequestMethodNotSupportedException( HttpRequestMethodNotSupportedException ex) {
		return ex.getMessage();

	}
	
	@ExceptionHandler(ResourceNotFoundEception.class)
	public ErrorResponse resourceNotFoundEception(ResourceNotFoundEception ex,HttpServletRequest request) {
		ErrorResponse errorResponse= new ErrorResponse();
		errorResponse.setStatusCode(204);
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setPath(request.getRequestURI());
		
		return errorResponse;
	}

}
