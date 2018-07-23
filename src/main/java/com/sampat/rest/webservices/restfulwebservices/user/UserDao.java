package com.sampat.rest.webservices.restfulwebservices.user;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class UserDao {

	private static Set<User> usersList = new HashSet<>();

	static {
		usersList.add(new User(1, "Adam", new Date()));
		usersList.add(new User(2, "Eve", new Date()));
		usersList.add(new User(3, "Jack", new Date()));
	}

	public Set<User> findAll() {
		return this.usersList;
	}

	public User save(User user) throws Exception {
		if (user.getId() == null) {
			user.setId(this.usersList.size() + 1);
		}
		if (!this.usersList.add(user)) {
			// entry already present, possibly a case you want to handle
			throw new Exception("User already exists in the set " + user);
		}
		return user;

	}

	public User findOne(Integer id) {
		for (User user : this.usersList) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	public User deleteUser(Integer id) {
		Iterator i = this.usersList.iterator();
		while (i.hasNext()) {
			User user = (User) i.next();
			if (user.getId() == id) {
				i.remove();
				return user;
			}
		}
		return null;
	}

}
