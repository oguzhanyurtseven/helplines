package com.helplines.conversation;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.helplines.entities.ExpertRequest;

@Model
@Stateful
@SessionScoped
public class ExpertRequestProducer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;

	private List<ExpertRequest> expertRequests;

	@Named
	@Produces
	public List<ExpertRequest> getExpertRequests() {
		return expertRequests;
	}

	public void setExpertRequests(List<ExpertRequest> expertRequests) {
		this.expertRequests = expertRequests;
	}

	public void onExpertRequestListChanged(
			@Observes(notifyObserver = Reception.IF_EXISTS) final ExpertRequest expertRequest) {
		retrieveAllExpertRequest();
	}

	@PostConstruct
	public void retrieveAllExpertRequest() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<ExpertRequest> criteriaQuery = criteriaBuilder
				.createQuery(ExpertRequest.class);
		Root<ExpertRequest> expertRequest = criteriaQuery
				.from(ExpertRequest.class);
		criteriaQuery.select(expertRequest);
		expertRequests = entityManager.createQuery(criteriaQuery)
				.getResultList();
	}

}
