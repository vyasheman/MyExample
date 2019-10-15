package com.example.json.JsonProcessorExample;

import java.util.List;




public class JsonRequestValidator {
	
	public JsonRespone validatorRequestId(String requestId) {
		
		JsonRespone response = new JsonRespone();
		if (requestId.isEmpty()) { // Validate request id
			response.setDeails("Request Id is mandatory");
			response.setStatus("400");
		} else {
			response.setStatus("200");
		}
		return response;
	}

	public JsonRespone validatorEmailId(String emailId) {
		
		JsonRespone response = new JsonRespone();
		if (emailId.isEmpty()) { // Validate request id
			response.setDeails("Email Id is mandatory");
			response.setStatus("400");
		} else {
			response.setStatus("200");
		}
		return response;
	}

	public JsonRespone validatorPepoleDetails(List<Person> people) {
		
		JsonRespone response = new JsonRespone();
		if (null == people || people.size() == 0) { // validate People size is
			response.setDeails("People is mandatory");
			response.setStatus("400");
		} else {
			for (Person person : people) {
				if (null == person.getName() || person.getName().equals("")) {
					response.setDeails("Person name is mandatory");
					response.setStatus("400");					
				}
			}
		}
		if (!response.getStatus().equals("400")) {
			response.setStatus("200");
		} 
		
		
		return response;

	}

}
