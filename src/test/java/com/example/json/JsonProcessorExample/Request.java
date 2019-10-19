package com.example.json.JsonProcessorExample;

public class Request {
	public static final String SUCCESSFUL =  "{\n" + 
			"       \"requestId\": \"4235-01277-239894\",\n" + 
			"       \"emailAddress\": \"purple-wiki@blocks.com\",\n" + 
			"       \"people\": [\n" + 
			"               {\"name\": \"John Smith\"},\n" + 
			"               {\"name\": \"Willy Wonka\"},\n" + 
			"               {\"name\": \"Margaret Watson\"}\n" + 
			"       ]\n" + 
			"}";
	
	public static final String REQUEST_ID_MISSING =  "{\n" + 
			"       \"requestId\": \"\",\n" + 
			"       \"emailAddress\": \"purple-wiki@blocks.com\",\n" + 
			"       \"people\": [\n" + 
			"               {\"name\": \"John Smith\"},\n" + 
			"               {\"name\": \"Willy Wonka\"},\n" + 
			"               {\"name\": \"Margaret Watson\"}\n" + 
			"       ]\n" + 
			"}";
	
	
	public static final String EMAIL_ID_MISSING =  "{\n" + 
			"       \"requestId\": \"4235-01277-239894\",\n" + 
			"       \"emailAddress\": \"\",\n" + 
			"       \"people\": [\n" + 
			"               {\"name\": \"John Smith\"},\n" + 
			"               {\"name\": \"Willy Wonka\"},\n" + 
			"               {\"name\": \"Margaret Watson\"}\n" + 
			"       ]\n" + 
			"}";
	
	public static final String NO_PERSON =  "{\n" + 
			"       \"requestId\": \"4235-01277-239894\",\n" + 
			"       \"emailAddress\": \"purple-wiki@blocks.com\",\n" + 
			"       \"people\": []\n" + 
			"}";
	
	public static final String PERSON_NAME_MISSING =  "{\n" + 
			"       \"requestId\": \"4235-01277-239894\",\n" + 
			"       \"emailAddress\": \"purple-wiki@blocks.com\",\n" + 
			"       \"people\": [\n" + 
			"               {\"name\": \"John Smith\"},\n" + 
			"               {\"name\": \"\"},\n" + 
			"               {\"name\": \"Margaret Watson\"}\n" + 
			"       ]\n" + 
			"}";
}
