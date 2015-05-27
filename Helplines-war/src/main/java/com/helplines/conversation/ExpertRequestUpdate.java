package com.helplines.conversation;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import com.helplines.entities.ExpertRequest;
import com.helplines.util.Session;

@Model
@SessionScoped
public class ExpertRequestUpdate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	FacesContext facesContext;

	@Inject
	ExpertRequestUpdateBean expertRequestUpdateBean;

	@Inject
	ExpertRequestProducer expertRequestProducer;

	private String sessionLink;

	private ExpertRequest expertRequest;

	private ExpertRequest selectedExpertRequset;

	@Produces
	public ExpertRequest getSelectedExpertRequset() {
		return selectedExpertRequset;
	}

	public void setSelectedExpertRequset(ExpertRequest selectedExpertRequset) {
		this.selectedExpertRequset = selectedExpertRequset;
	}

	@Produces
	public ExpertRequest getExpertRequest() {
		return expertRequest;
	}

	public void setExpertRequest(ExpertRequest expertRequest) {
		this.expertRequest = expertRequest;
	}

	public void initRequests() {
		for (int i = 0; i < expertRequestProducer.getExpertRequests().size(); i++) {
			if (Session.getUser().getId() == expertRequestProducer
					.getExpertRequests().get(i).getUser().getId()) {
				selectedExpertRequset = expertRequestProducer
						.getExpertRequests().get(i);
				sessionLink = selectedExpertRequset.getReqLink();
			}
		}
	}

	public String expertConnect() {
		try {
			expertRequest.setUpdateDate(new Date());
			expertRequest.setUpdateUser(Session.getUser().getFullName());
			expertRequest.setActive(true);
			expertRequestUpdateBean.updateExpertRequest(expertRequest);
			return "/connection.xhtml?faces-redirect=true";
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}
	
	public void addURL(String url){
		try {
			expertRequest.setActive(true);
			expertRequest.setReqLink(url);
			expertRequestUpdateBean.updateExpertRequest(expertRequest);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	

	public void userConnect() {
		expertRequestProducer.retrieveAllExpertRequest();
		
		for (int i = 0; i < expertRequestProducer.getExpertRequests().size(); i++) {
			System.out.println("A");
			if (Session.getUser().getId() == expertRequestProducer
					.getExpertRequests().get(i).getUser().getId()) {
				System.out.println("B");
				selectedExpertRequset = expertRequestProducer
						.getExpertRequests().get(i);
				sessionLink = selectedExpertRequset.getReqLink();
			}
		}
		
		System.out.println(sessionLink);
		
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		try {
			externalContext.redirect(sessionLink);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@PostConstruct
	public void initNewExpertRequest() {
		expertRequest = new ExpertRequest();
		selectedExpertRequset = new ExpertRequest();
		sessionLink = new String();
	}

}
