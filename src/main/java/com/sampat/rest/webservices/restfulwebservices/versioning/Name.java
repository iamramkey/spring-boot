package com.sampat.rest.webservices.restfulwebservices.versioning;

public class Name {

	private String firstname;
	private String lastName;

	public Name() {
		super();
	}

	public Name(String firstname, String lastName) {
		super();
		this.firstname = firstname;
		this.lastName = lastName;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
