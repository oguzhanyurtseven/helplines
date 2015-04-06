package com.helplines.expert;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import com.helplines.entities.ExpertRequest;

@Model
@Stateful
public class ExpertRequestRegistrationBean {

	@Inject
	private EntityManager entityManager;

	@Inject
	private Event<ExpertRequest> expertRequestEvent;

	private ExpertRequest expertRequest;

	@Named
	@Produces
	public ExpertRequest getExpertRequest() {
		return expertRequest;
	}

	public void setExpertRequest(ExpertRequest expertRequest) {
		this.expertRequest = expertRequest;
	}

	public void registerExpertRequest() {
		try {
			entityManager.persist(expertRequest);
			expertRequestEvent.fire(expertRequest);
			initNewExpertRequest();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@PostConstruct
	public void initNewExpertRequest() {
		expertRequest = new ExpertRequest();
	}

}
