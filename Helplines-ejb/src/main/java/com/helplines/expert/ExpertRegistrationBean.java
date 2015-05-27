package com.helplines.expert;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.Produces;

import com.helplines.entities.Role;
import com.helplines.entities.User;

@Produces
@Stateless
public class ExpertRegistrationBean {

	@Inject
	EntityManager entityManager;

	@Inject
	private Event<User> userEvent;

	public void updateUser(User user) {
		user.setRole(entityManager.find(Role.class, Long.valueOf(2)));
		try {
			entityManager.persist(entityManager.merge(user));
			userEvent.fire(user);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
