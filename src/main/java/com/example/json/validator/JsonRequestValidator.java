package com.example.json.validator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.json.exception.ExceptionThrow;
import com.example.json.model.CustomException;

import com.example.json.model.Person;



@Component
public class JsonRequestValidator {
	
	@Autowired
	ExceptionThrow exceptionThrow;
	
	public void validatorRequestId(String requestId) throws CustomException {
		if (null == requestId || requestId.isEmpty()) { // Validate request id			
			exceptionThrow.throwCustomException("Request Id is mandatory");			
		} 
	}

	public void  validatorEmailId(String emailId) throws CustomException {
		if (null == emailId || emailId.isEmpty()) { // Validate request id			
			exceptionThrow.throwCustomException("Email id is mandatory");		
		}
	}

	public void validatorPepoleDetails(List<Person> people) throws CustomException {
		
		if (null == people || people.size() == 0) { // validate People size is			
			exceptionThrow.throwCustomException("People is mandatory field");
		}
			for (Person person : people) {
				if (null == person.getName() || person.getName().equals("")) {
					exceptionThrow.throwCustomException("Person name is mandatory");									
				}
				
			}
	}

}
