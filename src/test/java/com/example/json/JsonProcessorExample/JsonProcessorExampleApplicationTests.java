package com.example.json.JsonProcessorExample;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.json.model.JsonRequest;
import com.example.json.model.JsonResponse;
import com.google.gson.Gson;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JsonProcessorExampleApplicationTests extends AbstractTest{

	@Override
	   @Before
	   public void setUp() {
	      super.setUp();
	   }
	
	
	
	
	@Autowired
	JsonResponse response;
	
	String uri ="/process";
	
	
	
	
	// Check Request is successful 
	@Test
	public void requestSuccesful() throws Exception {
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
			      .contentType(MediaType.APPLICATION_JSON_VALUE).content(Request.SUCCESSFUL)).andReturn();
		Gson gson = new Gson();
		JsonRequest p = gson.fromJson(Request.SUCCESSFUL, JsonRequest.class); // String to Json
		
		response.setStatus(HttpStatus.valueOf("OK").getReasonPhrase());
		response.setDeails("processed "+p.getPeople().size()+" people for "+p.emailAddress);
		
		String json = gson.toJson(response); // Json to String 
		
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, json);
		
	}	
	
	@Test
	public void requestIdError() throws Exception {
		Gson gson = new Gson();
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
			      .contentType(MediaType.APPLICATION_JSON_VALUE).content(Request.REQUEST_ID_MISSING)).andReturn();
		
		response.setStatus(HttpStatus.valueOf("BAD_REQUEST").getReasonPhrase());
		response.setDeails("Request Id is mandatory");
		
		String json = gson.toJson(response); // Json to String 
		
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, json);
		
	}	
	 
	@Test
	public void requestEmailIdError() throws Exception {
		Gson gson = new Gson();
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
			      .contentType(MediaType.APPLICATION_JSON_VALUE).content(Request.EMAIL_ID_MISSING)).andReturn();
		
		
		response.setStatus(HttpStatus.valueOf("BAD_REQUEST").getReasonPhrase());
		response.setDeails("Email id is mandatory");
		
		String json = gson.toJson(response); // Json to String 
		
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, json);
		
	}	
	
	@Test
	public void peopleNotFound() throws Exception {
		Gson gson = new Gson();
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
			      .contentType(MediaType.APPLICATION_JSON_VALUE).content(Request.NO_PERSON)).andReturn();
		
		
		response.setStatus(HttpStatus.valueOf("BAD_REQUEST").getReasonPhrase());
		response.setDeails("People is mandatory field");
		
		String json = gson.toJson(response); // Json to String 
		
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, json);
		
	}	

	
	@Test
	public void personNameNotFound() throws Exception {
		Gson gson = new Gson();
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
			      .contentType(MediaType.APPLICATION_JSON_VALUE).content(Request.PERSON_NAME_MISSING)).andReturn();
		
		
		response.setStatus(HttpStatus.valueOf("BAD_REQUEST").getReasonPhrase());
		response.setDeails("Person name is mandatory");
		
		String json = gson.toJson(response); // Json to String 
		
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, json);
		
	}	
}