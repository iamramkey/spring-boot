package com.sampat.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningController {

	@GetMapping(path = "/v1/person")
	public Person1 person1() {
		Person1 p1 = new Person1("Jack Adams");
		return p1;
	}

	@GetMapping(path = "v2/person")
	public Person2 person2() {
		Person2 p2 = new Person2(new Name("Jack", "Adams"));
		return p2;
	}

	@GetMapping(value = "/person/param", params = "version=1")
	public Person1 personParam() {
		Person1 p1 = new Person1("Jack Adams");
		return p1;
	}

	@GetMapping(value = "/person/param", params = "version=2")
	public Person2 person2Param() {
		Person2 p2 = new Person2(new Name("Jack", "Adams"));
		return p2;
	}


	@GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
	public Person1 personHeader() {
		Person1 p1 = new Person1("Jack Adams");
		return p1;
	}

	@GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
	public Person2 person2Header() {
		Person2 p2 = new Person2(new Name("Jack", "Adams"));
		return p2;
	}

	@GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v1+json")
	public Person1 personProduces() {
		Person1 p1 = new Person1("Jack Adams");
		return p1;
	}

	@GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v2+json")
	public Person2 person2Produces() {
		Person2 p2 = new Person2(new Name("Jack", "Adams"));
		return p2;
	}


}
