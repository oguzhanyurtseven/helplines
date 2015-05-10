package com.helplines.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

	@Length(max = 200)
	@Column(name = "BIOGRAPHY", length = 200)
	private String biography;

	@Email
	@Column(name = "PAYPAL")
	private String paypalMail;

	@OneToMany(mappedBy = "expert", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ExpertRequest> expertRequests = new ArrayList<ExpertRequest>();

	@ManyToOne
	@JoinColumn(name = "ROLE_ID")
	private Role role;

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

	public List<ExpertRequest> getExpertRequests() {
		return expertRequests;
	}

	public void setExpertRequests(List<ExpertRequest> expertRequests) {
		this.expertRequests = expertRequests;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
