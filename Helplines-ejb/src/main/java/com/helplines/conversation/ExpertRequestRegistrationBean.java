package com.helplines.conversation;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.Produces;

import com.helplines.entities.ExpertRequest;

@Produces
@Stateless
public class ExpertRequestRegistrationBean {

	@Inject
	EntityManager entityManager;

	@Inject
	private Event<ExpertRequest> expertRequestEvent;

	public void registerExpertRequest(ExpertRequest expertRequest) {
		try {
			entityManager.persist(expertRequest);
			expertRequestEvent.fire(expertRequest);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
