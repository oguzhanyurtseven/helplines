package com.helplines.user;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import com.helplines.entities.User;

@Model
@Stateful
public class UserRegistrationBean {

	@Inject
	private EntityManager entityManager;

	@Inject
	private Event<User> userEvent;

	private User user;

	@Named
	@Produces
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void registerUser() {
		try {
			entityManager.persist(user);
			userEvent.fire(user);
			initNewUser();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@PostConstruct
	public void initNewUser() {
		user = new User();
	}

}
