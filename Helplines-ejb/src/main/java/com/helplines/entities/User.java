package com.helplines.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USERS")
public class User extends UserBase implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ExpertRequest> expertRequests = new ArrayList<ExpertRequest>();

	@ManyToOne
	@JoinColumn(name = "ROLE_ID")
	private Role role;

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
