package com.ShirtLog;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ShirtLogException {
	
	static Logger log = Logger.getLogger(ShirtLogException.class);
	
	@ExceptionHandler(NoSuchColorException.class)
	public ResponseEntity<Object> displayThis(NoSuchColorException ne) {
		PropertyConfigurator.configure("log4j.properties");
		log.error(ne);
		return new ResponseEntity<>("Error Occurs",HttpStatus.NOT_FOUND);
	}
	
		
	

}
