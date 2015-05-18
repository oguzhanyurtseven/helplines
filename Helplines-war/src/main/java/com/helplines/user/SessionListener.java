package com.helplines.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

import com.helplines.entities.User;

@ApplicationScoped
public class SessionListener implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<User> users;

	public void addUser(User user) {
		users.add(user);

	}

	public void deleteUser(User user) {
		users.remove(user);
	}

	@PostConstruct
	public void init() {
		users = new ArrayList<User>();
	}

}
