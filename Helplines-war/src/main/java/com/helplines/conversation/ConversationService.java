package com.helplines.conversation;

import java.io.IOException;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ConversationService")
public class ConversationService extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	ExpertRequestUpdate expertRequestUpdate;

	private String pageLocation;

	@Produces
	public String getPageLocation() {
		return pageLocation;
	}

	public void setPageLocation(String pageLocation) {
		this.pageLocation = pageLocation;
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		pageLocation = request.getParameter("data");
		expertRequestUpdate.addURL(pageLocation);

	}

	public void initNewLocaciton() {
		pageLocation = new String();
	}

}
