package com.sampat.rest.webservices.restfulwebservices.dbuser;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sampat.rest.webservices.restfulwebservices.exception.UserNotFoundException;

@RestController
@RequestMapping("/db")
public class DBUserController {

	@Autowired
	private DBUserDao service;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	// list all users
	// GET - /users
	@GetMapping(path = "/users")
	public List<User> usersList() {
		return userRepository.findAll();
	}

	// find one user by id
	// GET - /users/1
	@GetMapping(path = "/users/{id}")
	public Resource<User> findUser(@PathVariable Integer id) {

		Optional<User> user = userRepository.findById(id);

		if (!user.isPresent()) {
			throw new UserNotFoundException("User id : " + id);
		}

//		User user = service.findOne(id);
//		if (user == null) {
//			throw new UserNotFoundException("User id : " + id);
//		}

		Resource<User> resource = new Resource<User>(user.get());

		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).usersList());

		resource.add(linkTo.withRel("all-users"));
		return resource;
	}

	// find one user by id
	// GET - /users/1
	@DeleteMapping(path = "/users/{id}")
	public void deleteUser(@PathVariable Integer id) {
//		User user = service.deleteUser(id);
//		if (user == null) {
//			throw new UserNotFoundException("User id : " + id);
//		}
//		return user;
		userRepository.deleteById(id);
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
		User savedUser = userRepository.save(user);
		location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@GetMapping(path = "/users/{id}/posts")
	public List<Post> getAllPosts(@PathVariable Integer id) {
		Optional<User> user = userRepository.findById(id);
		if (!user.isPresent()) {
			throw new UserNotFoundException("User id : " + id);
		}

		return user.get().getPosts();
	}

	@PostMapping(path = "/users/{id}/posts")
	public ResponseEntity<Object> createANewPost(@PathVariable Integer id, @RequestBody Post post) {
		Optional<User> userOptional = userRepository.findById(id);
		if (!userOptional.isPresent()) {
			throw new UserNotFoundException("User id : " + id);
		}

		User user = userOptional.get();

		post.setUser(user);

		postRepository.save(post);

		URI location;
		location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId()).toUri();

		return ResponseEntity.created(location).build();
	}

}
