package com.marolix.session.JuneJulySpringBoot.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@ControllerAdvice
//@ResponseBody
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(EmployeeManagementException.class)
	public ResponseEntity<ErrorInfo>  handleEmployeeMException(EmployeeManagementException e) {

		ErrorInfo er = new ErrorInfo();
		er.setErrorMessage(e.getMessage());
		er.setErrorCode(HttpStatus.BAD_REQUEST.value());
		er.setOccuredAt(LocalDateTime.now());
		return new ResponseEntity<ErrorInfo>(er,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorInfo>  handlegeneralException(Exception e) {

		ErrorInfo er = new ErrorInfo();
		er.setErrorMessage("some thing went wrong in the server ");
		er.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		er.setOccuredAt(LocalDateTime.now());
		return new ResponseEntity<ErrorInfo>(er,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
