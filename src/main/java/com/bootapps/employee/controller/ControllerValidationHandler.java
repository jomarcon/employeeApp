package com.bootapps.employee.controller;

import java.util.Locale;

import javax.persistence.PersistenceException;
import javax.validation.ConstraintViolationException;

import org.junit.Ignore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.bootapps.employee.dto.MessageDTO;
import com.bootapps.employee.dto.MessageType;

@ControllerAdvice
public class ControllerValidationHandler {

	@Autowired	
	private MessageSource messageSrc;
	
	private static final String[] ERRORS = {"error.name.notnull", "error.department.notnull", 
			"error.salary.notnull", "error.salary.digits"};
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public MessageDTO processValidationError(MethodArgumentNotValidException ex) {
		BindingResult result = ex.getBindingResult();
		FieldError error = result.getFieldError();

		return processFieldError(error);
	}
	
	@ExceptionHandler(PersistenceException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public MessageDTO processConstraintError(PersistenceException ex) {
		String msg = "";
		if ( ex.getCause() instanceof ConstraintViolationException ) {		
			for ( String error : ERRORS ) {
				if ( ex.getCause().toString().contains(error)) {					
					msg = messageSrc.getMessage(error, null, LocaleContextHolder.getLocale());			
				}
			}			
		}		
		
		return new MessageDTO(MessageType.ERROR, msg);
	}

	private MessageDTO processFieldError(FieldError error) {
		MessageDTO message = null;
		if (error != null) {
			Locale currentLocale = LocaleContextHolder.getLocale();
			String msg = messageSrc.getMessage(error.getDefaultMessage(), null, currentLocale);
			message = new MessageDTO(MessageType.ERROR, msg);
		}
		return message;
	}
}
