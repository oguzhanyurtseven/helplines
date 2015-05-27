package com.helplines.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import com.helplines.entities.User;

@Named
@ApplicationScoped
public class SessionListener implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<User> users;

	private List<User> experts;

	@Produces
	public List<User> getExperts() {
		return experts;
	}

	public void setExperts(List<User> experts) {
		this.experts = experts;
	}

	@Produces
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public void addUser(User user) {
		users.add(user);
		updateExperts();

	}

	public void deleteUser(User user) {
		users.remove(user);
		updateExperts();
	}

	@PostConstruct
	public void init() {
		users = new ArrayList<User>();
		experts = new ArrayList<User>();
	}

	public void updateExperts() {
		experts.clear();
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getRole().getId() == Long.valueOf(2)) {
				experts.add(users.get(i));
			}
		}
	}

}
