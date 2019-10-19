package com.example.json.exception;

import org.springframework.stereotype.Component;

import com.example.json.model.CustomException;

@Component
public class ExceptionThrow {
	public CustomException throwCustomException (String msg) throws CustomException {
		System.out.println("throwCustomException "  + msg);
		CustomException customException = new CustomException();
		customException.setCode("400");
		customException.setMsg(msg);
		throw customException;
	}
}
