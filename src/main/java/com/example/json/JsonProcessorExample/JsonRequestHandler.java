package com.example.json.JsonProcessorExample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class JsonRequestHandler {

	Logger log = LoggerFactory.getLogger(JsonRequestHandler.class);
	
	
	
	
	
	@PostMapping(path= "/process")
	public ResponseEntity<JsonRespone> process(@RequestBody JsonRequest request) {
		
		log.info("Got Request " +  request);
		
		
		JsonRespone response  = new JsonRespone();
		JsonRequestValidator jsonRequestValidator  = new JsonRequestValidator();
		
		
		
		if (null == request)
		{
			response.setDeails("Blank Request");
			return  new ResponseEntity<JsonRespone>(response, HttpStatus.BAD_REQUEST);
		} else {
			
			response= jsonRequestValidator.validatorRequestId(request.getRequestId());
			System.out.println(" .. ." + response.getStatus());
			if (response.getStatus().equals("200")) {
				response = jsonRequestValidator.validatorEmailId(request.getEmailAddress());				
				if (response.getStatus().equals("200")) {
					response = jsonRequestValidator.validatorPepoleDetails(request.getPeople());
				}
			}
			
			if (response.getStatus().equals("200")) {
				log.error("Request successfull processed" +  request);
				response.setDeails("Request Successful Accepted");
				return new ResponseEntity<JsonRespone>(response, HttpStatus.ACCEPTED);
			} else {
				log.error("Request failed " +  request + " with reason "+  response.getDeails() );
				return new ResponseEntity<JsonRespone>(response, HttpStatus.BAD_REQUEST);
			}
		}
		
		
		
		
	}
	
}
