package com.sampat.rest.webservices.restfulwebservices.user;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.sampat.rest.webservices.restfulwebservices.exception.UserNotFoundException;

@RestController
public class UserController {

	@Autowired
	private UserDao service;

	// list all users
	// GET - /users
	@GetMapping(path = "/users")
	public Set usersList() {
		return service.findAll();
	}

	// find one user by id
	// GET - /users/1
	@GetMapping(path = "/users/{id}")
	public Resource<User> findUser(@PathVariable Integer id) {
		User user = service.findOne(id);
		if (user == null) {
			throw new UserNotFoundException("User id : " + id);
		}

		Resource<User> resource = new Resource<User>(user);

		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).usersList());

		resource.add(linkTo.withRel("all-users"));
		return resource;
	}

	// find one user by id
	// GET - /users/1
	@DeleteMapping(path = "/users/{id}")
	public User deleteUser(@PathVariable Integer id) {
		User user = service.deleteUser(id);
		if (user == null) {
			throw new UserNotFoundException("User id : " + id);
		}
		return user;
	}

	// create a user by passing values
	@PostMapping(path = "/users")
	public ResponseEntity<Object> saveUser(@Valid @RequestBody User user) throws Exception {
		user.setId(null);
		if (user.getName() == null || user.getName().trim().length() == 0) {
			throw new Exception("Please provide a proper name for " + user);
		}
		if (user.getDateOfBirth() == null || user.getDateOfBirth().toString().length() == 0) {
			throw new Exception("Please provide a proper date of birth for " + user);
		}
		URI location;
		User savedUser = service.save(user);
		location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@GetMapping(path = "/filtered-users")
	public MappingJacksonValue returnAllUsers() {
		Set<FilteredUser> usersList = FilteredUser.findAll(service);
		MappingJacksonValue mapping = new MappingJacksonValue(usersList);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("posts", "dateOfBirth");
		FilterProvider filters = new SimpleFilterProvider().addFilter("UserFilter", filter);
		mapping.setFilters(filters);
		return mapping;
	}

}
