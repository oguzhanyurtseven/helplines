package com.helplines.util;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.helplines.entities.User;

public class Session {

	public static HttpSession getSession() {
		return (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
	}

	public static HttpServletRequest getRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance()
				.getExternalContext().getRequest();
	}

	public static String getUserName() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		return session.getAttribute("userName").toString();
	}

	public static String getUserID() {
		HttpSession session = getSession();
		if (session != null)
			return (String) session.getAttribute("userID");
		else
			return null;
	}
	
	public static User getUser() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		return (User) session.getAttribute("user");
	}
}
