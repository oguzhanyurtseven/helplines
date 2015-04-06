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
public class ExpertRegistrationBean {

	@Inject
	private EntityManager entityManager;

	@Inject
	private Event<Expert> expertEvent;

	private Expert expert;

	@Named
	@Produces
	public Expert getExpert() {
		return expert;
	}

	public void setExpert(Expert expert) {
		this.expert = expert;
	}

	private void registerExpert() {
		try {
			entityManager.persist(expert);
			expertEvent.fire(expert);
			initNewExpert();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@PostConstruct
	private void initNewExpert() {
		expert = new Expert();
	}

}
