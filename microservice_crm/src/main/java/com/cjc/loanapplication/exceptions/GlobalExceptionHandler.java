package com.cjc.loanapplication.exceptions;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(NoEnquiryFoundException.class)
	public ResponseEntity<APIError> noEnquiryFoundException(NoEnquiryFoundException e,HttpServletRequest request)
	{
		APIError error=new APIError();
		error.setDate(new Date());
		error.setStatuscode(HttpStatus.BAD_REQUEST.value());
		error.setMessage(e.getMessage());
		error.setPath(request.getRequestURI());
		error.setHttpmessage(HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<APIError>(error,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(NoApprovedEnquiryFoundException.class)
	public ResponseEntity<APIError> noApprovedEnquiryFoundException(NoApprovedEnquiryFoundException e,HttpServletRequest request)
	{
		APIError error=new APIError();
		error.setDate(new Date());
		error.setStatuscode(HttpStatus.BAD_REQUEST.value());
		error.setMessage(e.getMessage());
		error.setPath(request.getRequestURI());
		error.setHttpmessage(HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<APIError>(error,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoRejectedEnquiryFoundException.class)
	public ResponseEntity<APIError> noRejectedEnquiryFoundException(NoRejectedEnquiryFoundException e,HttpServletRequest request)
	{
		APIError error=new APIError();
		error.setDate(new Date());
		error.setStatuscode(HttpStatus.BAD_REQUEST.value());
		error.setMessage(e.getMessage());
		error.setPath(request.getRequestURI());
		error.setHttpmessage(HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<APIError>(error,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoPendingEnquiryFoundException.class)
	public ResponseEntity<APIError> noPendingEnquiryFoundException(NoPendingEnquiryFoundException e, HttpServletRequest request)
	{
		
		APIError error=new APIError();
		error.setDate(new Date());
		error.setStatuscode(HttpStatus.BAD_REQUEST.value());
		error.setMessage(e.getMessage());
		error.setPath(request.getRequestURI());
		error.setHttpmessage(HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<APIError>(error,HttpStatus.BAD_REQUEST);
		
	}
	
	
	@ExceptionHandler(NoEnquiryFoundToUpdateException.class)
	public ResponseEntity<APIError> noEnquiryFoundToUpdateException(NoEnquiryFoundToUpdateException e,HttpServletRequest request)
	{
		APIError error=new APIError();
		error.setDate(new Date());
		error.setStatuscode(HttpStatus.BAD_REQUEST.value());
		error.setMessage(e.getMessage());
		error.setPath(request.getRequestURI());
		error.setHttpmessage(HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<APIError>(error,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>>MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e,HttpServletRequest request){
		Map<String, String>error = new HashMap<String, String>();
		e.getBindingResult().getAllErrors().forEach((er)->{
			String filedName = ((FieldError)er).getField();
			String msg = er.getDefaultMessage();
			error.put(filedName, msg);
		});
		return new ResponseEntity<Map<String,String>>(error,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EnquiryIdNotFoundException.class)
	public ResponseEntity<APIError> enquiryIdNotFoundException(EnquiryIdNotFoundException e, HttpServletRequest request)
	{
		APIError error=new APIError();
		error.setDate(new Date());
		error.setStatuscode(HttpStatus.BAD_REQUEST.value());
		error.setMessage(e.getMessage());
		error.setPath(request.getRequestURI());
		error.setHttpmessage(HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<APIError>(error,HttpStatus.BAD_REQUEST);
		
	}
	
}
