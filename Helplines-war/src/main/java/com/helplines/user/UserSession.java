package com.helplines.user;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import com.helplines.entities.User;
import com.helplines.user.UserListProducer;
import com.helplines.util.HashingBean;
import com.helplines.util.Session;

@Model
@SessionScoped
public class UserSession implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	UserListProducer userListProducer;

	HashingBean hashingBean = new HashingBean();

	private User user;

	public void setUser(User user) {
		this.user = user;
	}

	@Named
	public User getUser() {
		return user;
	}

	protected boolean result() {
		boolean result = false;
		for (int i = 0; i < userListProducer.getUsers().size();) {
			if (user.getEmail().equals(
					userListProducer.getUsers().get(i).getEmail())
					&& hashingBean.hashString(user.getPassword()).equals(
							userListProducer.getUsers().get(i).getPassword())) {
				result = true;
				user = userListProducer.getUsers().get(i);
				break;
			} else {
				result = false;
				initNewUser();
				break;
			}
		}
		return result;
	}

	public String login() {
		if (result()) {
			HttpSession session = Session.getSession();
			session.setAttribute("user", user);
			return "/success.xhtml";

		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Geçersiz giriş denemesi!",
							"Yanlış kullanıcı adı veya parola"));
			return "/index.xhtml";
		}
	}

	public String logout() {
		HttpSession session = Session.getSession();
		session.invalidate();
		return "/index.xhtml";
	}

	@PostConstruct
	public void initNewUser() {
		user = new User();
	}

}
