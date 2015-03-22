package com.helplines.expert;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import com.helplines.entities.Expert;

@Model
@Stateful
public class ExpertRequestRegistrationBean {

	@Inject
	private EntityManager entityManager;

	@Inject
	private Event<Expert> expertRequestEvent;

	private Expert expertRequest;

	@Named
	@Produces
	public Expert getExpertRequest() {
		return expertRequest;
	}

	public void setExpertRequest(Expert expert) {
		this.expertRequest = expertRequest;
	}

	private void registerExpertRequest() {
		try {
			entityManager.persist(expertRequest);
			expertRequestEvent.fire(expertRequest);
			initNewExpert();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@PostConstruct
	private void initNewExpert() {
		expertRequest = new Expert();
	}

}
