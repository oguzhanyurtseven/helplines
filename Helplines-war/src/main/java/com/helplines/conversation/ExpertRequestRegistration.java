package com.helplines.conversation;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import com.helplines.entities.Category;
import com.helplines.entities.ExpertRequest;
import com.helplines.util.Session;

@Model
@SessionScoped
public class ExpertRequestRegistration implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	ExpertRequestRegistrationBean expertRequestRegistrationBean;

	private ExpertRequest expertRequest;

	private String categoryName;

	@Produces
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Produces
	public ExpertRequest getExpertRequest() {
		return expertRequest;
	}

	public void setExpertRequest(ExpertRequest expertRequest) {
		this.expertRequest = expertRequest;
	}

	public void registerExpertRequest() {
		try {
			expertRequest.setActive(false);
			expertRequest.setCreateDate(new Date());
			expertRequest.setCreateUser(Session.getUser().getFullName());
			expertRequest.setUser(Session.getUser());
			expertRequest.setCategory(Category.valueOf(categoryName));
			expertRequestRegistrationBean.registerExpertRequest(expertRequest);
			initNewExpertRequest();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	@PostConstruct
	public void initNewExpertRequest() {
		expertRequest = new ExpertRequest();
		categoryName = new String();
	}

}
