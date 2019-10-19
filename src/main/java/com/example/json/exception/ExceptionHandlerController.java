package com.example.json.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.json.model.CustomException;
import com.example.json.model.JsonResponse;

@ControllerAdvice
public class ExceptionHandlerController {
	
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<JsonResponse> customException(CustomException e){
		System.out.println("customException....."+  e.getMessage());
		JsonResponse  response  = new JsonResponse();
		response.setStatus(HttpStatus.valueOf("BAD_REQUEST").getReasonPhrase());
		response.setDeails(e.getMsg());
		return new ResponseEntity<JsonResponse>(response, HttpStatus.BAD_REQUEST) ;		
	}
	
}
