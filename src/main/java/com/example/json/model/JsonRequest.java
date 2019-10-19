package com.example.json.model;

import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class JsonRequest {

	public String requestId;
	public String emailAddress;
	
	public List<Person> people;

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public List<Person> getPeople() {
		return people;
	}

	public void setPeople(List<Person> people) {
		this.people = people;
	}

	
	
	
}
