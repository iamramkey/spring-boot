package com.sampat.rest.webservices.restfulwebservices.helloworld;

public class JsonObject {

	private String message;
	public JsonObject(String message) {
		// TODO Auto-generated constructor stub
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	

	@Override
	public String toString() {
		return "JsonObject [message=" + message + "]";
	}
	
	

}
