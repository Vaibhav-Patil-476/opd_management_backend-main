package com.OPD_Managemnet_System.ExceptionHandling;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.OPD_Managemnet_System.Response.Error_Response;

//This class handle all exception Globally
@RestControllerAdvice
public class Globel_Exception_Handler {
	
//This Method handle for validation exception 
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handlevalidationException(MethodArgumentNotValidException ex){
		Map<String, String> error = new HashMap<>();
		ex.getBindingResult()
		  .getFieldErrors()
		  .forEach(errors ->
		      error.put(errors.getField(), errors.getDefaultMessage())
		  );
		return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	//This Exception Handle Resource Not Found Related 
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Error_Response> handleResourceNotFoundException(ResourceNotFoundException ex){
		
		Error_Response error = new Error_Response(
				HttpStatus.NOT_FOUND.value(),
				ex.getMessage()
				);
		
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
		
	}
	//This Exception Handle Database Connection  Not Found 
	@ExceptionHandler(Dublicate_Exception.class)
	public ResponseEntity<Error_Response> handleDublicate_Exception(Dublicate_Exception ex){
		
		Error_Response error = new Error_Response(
				HttpStatus.INTERNAL_SERVER_ERROR.value(),
				ex.getMessage());
		return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
					
	}
	
	//This method handle database exception 
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<Error_Response> handleDatabaseException(DatabaseException ex){
		 Error_Response error = new Error_Response(
				 HttpStatus.INTERNAL_SERVER_ERROR.value(),
				 ex.getMessage());
		 return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//This method id Default PreDefine Exception
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Error_Response> handlexception(Exception ex){
		Error_Response error = new Error_Response(
				HttpStatus.INTERNAL_SERVER_ERROR.value(), 
				"Something Wents Wrong....!");
		return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
				
	}
}


