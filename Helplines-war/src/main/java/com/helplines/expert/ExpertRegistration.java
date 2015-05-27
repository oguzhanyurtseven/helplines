package com.helplines.expert;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import com.helplines.entities.Category;
import com.helplines.entities.User;
import com.helplines.util.Session;

@Model
@RequestScoped
public class ExpertRegistration {

	@Inject
	ExpertRegistrationBean expertRegistrationBean;

	private User user;

	private String categoryName;

	@Produces
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Produces
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void updateUser() {
		user.setCategory(Category.valueOf(categoryName));
		user.setBiography(user.getCategory().name() + "    "
				+ user.getBiography());
		try {
			expertRegistrationBean.updateUser(user);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	@PostConstruct
	public void initNewUser() {
		user = Session.getUser();
		categoryName = new String();
	}

}
