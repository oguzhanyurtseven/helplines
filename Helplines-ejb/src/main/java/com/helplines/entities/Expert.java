package com.helplines.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "EXPERTS")
public class Expert extends UserBase implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Email
	@Column(name = "GOOGLE")
	private String googleMail;

	@Length(max = 200)
	@Column(name = "LINKEDIN", length = 200)
	private String linkedin;

	@Length(max = 200)
	@Column(name = "SOFLOW", length = 200)
	private String stackOverFlow;

	@Length(max = 200)
	@Column(name = "PROFILE", length = 200)
	private String helpLinesProfile;

	@Length(max = 200)
	@Column(name = "BIOGRAPHY", length = 200)
	private String biography;

	@Email
	@Column(name = "PAYPAL")
	private String paypalMail;

	@OneToMany(mappedBy = "expert", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<UserRole> userRoles = new ArrayList<UserRole>();

	@OneToMany(mappedBy = "expert", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ExpertRequest> expertRequests = new ArrayList<ExpertRequest>();

	@OneToMany(mappedBy = "expert", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CreditCard> creditCards = new ArrayList<CreditCard>();

	public String getGoogleMail() {
		return googleMail;
	}

	public void setGoogleMail(String googleMail) {
		this.googleMail = googleMail;
	}

	public String getLinkedin() {
		return linkedin;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}

	public String getStackOverFlow() {
		return stackOverFlow;
	}

	public void setStackOverFlow(String stackOverFlow) {
		this.stackOverFlow = stackOverFlow;
	}

	public String getHelpLinesProfile() {
		return helpLinesProfile;
	}

	public void setHelpLinesProfile(String helpLinesProfile) {
		this.helpLinesProfile = helpLinesProfile;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public String getPaypalMail() {
		return paypalMail;
	}

	public void setPaypalMail(String paypalMail) {
		this.paypalMail = paypalMail;
	}

	public List<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public List<ExpertRequest> getExpertRequests() {
		return expertRequests;
	}

	public void setExpertRequests(List<ExpertRequest> expertRequests) {
		this.expertRequests = expertRequests;
	}

	public List<CreditCard> getCreditCards() {
		return creditCards;
	}

	public void setCreditCards(List<CreditCard> creditCards) {
		this.creditCards = creditCards;
	}

}
