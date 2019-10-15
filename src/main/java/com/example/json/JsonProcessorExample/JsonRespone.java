package com.example.json.JsonProcessorExample;

public class JsonRespone {
	private String status="";		// 200 Successful 400 error 
	private String deails;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDeails() {
		return deails;
	}
	public void setDeails(String deails) {
		this.deails = deails;
	}
	
}
