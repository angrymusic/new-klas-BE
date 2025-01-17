package com.SoftwareEngineering.AcademicAdmin.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.SoftwareEngineering.AcademicAdmin.exception.department.DepartmentNotFound;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(DepartmentNotFound.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ExceptionResponse departmentNotFoundException(Exception e) {
		return new ExceptionResponse(e.getMessage(), HttpStatus.BAD_REQUEST, LocalDateTime.now());
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ExceptionResponse methodArgumentNotValidHandler(MethodArgumentNotValidException e) {
		return new ExceptionResponse(e.getBindingResult().getAllErrors().get(0).getDefaultMessage()
			, HttpStatus.BAD_REQUEST, LocalDateTime.now());
	}
}
