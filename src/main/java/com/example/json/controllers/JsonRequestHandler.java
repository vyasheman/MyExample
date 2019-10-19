package com.example.json.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.json.exception.ExceptionThrow;
import com.example.json.model.CustomException;
import com.example.json.model.JsonRequest;
import com.example.json.model.JsonResponse;

import com.example.json.validator.JsonRequestValidator;


@RestController
public class JsonRequestHandler {

	Logger log = LoggerFactory.getLogger(JsonRequestHandler.class);
	
	@Autowired
	JsonRequestValidator jsonRequestValidator;
	
	@Autowired
	ExceptionThrow exceptionThrow;
	
	
	@PostMapping(value = "/process", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JsonResponse> process(@RequestBody JsonRequest request) throws CustomException {	
		log.info("Got Request " +  request);

		JsonResponse response  = new JsonResponse();
		if (null == request)
		{
			exceptionThrow.throwCustomException("Request id cann't be blank"); 			
		} 			
			jsonRequestValidator.validatorRequestId(request.getRequestId());
			jsonRequestValidator.validatorEmailId(request.getEmailAddress());				
			jsonRequestValidator.validatorPepoleDetails(request.getPeople());
			
			response.setStatus(HttpStatus.valueOf("OK").getReasonPhrase());
			response.setDeails("processed "+request.getPeople().size() +" people for "+ request.getEmailAddress());
			
			return new ResponseEntity<JsonResponse>(response, HttpStatus.ACCEPTED);
	}
	
}



