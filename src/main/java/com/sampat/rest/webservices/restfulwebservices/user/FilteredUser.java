package com.sampat.rest.webservices.restfulwebservices.user;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("UserFilter")
public class FilteredUser extends User {

	public FilteredUser(Integer id, String name, Date dateOfBirth) {
		super(id, name, dateOfBirth);
	}

	public static Set<FilteredUser> findAll(UserDao service) {
		Set<User> users = service.findAll();
		Object[] usersList = users.toArray();
		Set<FilteredUser> fUsers = new HashSet<FilteredUser>();
		for (int i = 0; i < usersList.length; i++) {
			User user = (User) usersList[i];
			FilteredUser fUser = new FilteredUser(user.getId(), user.getName(), user.getDateOfBirth());
			fUsers.add(fUser);
		}
		return fUsers;
	}
}
