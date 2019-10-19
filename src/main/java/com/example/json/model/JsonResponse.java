package com.example.json.model;

import org.springframework.stereotype.Component;

@Component
public class JsonResponse {
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
	@Override
	public String toString() {
		return "JsonRespone [status=" + status + ", deails=" + deails + "]";
	}
	
	
	
}
