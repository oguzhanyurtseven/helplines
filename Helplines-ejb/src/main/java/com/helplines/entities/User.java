package com.helplines.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USERS")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Length(max = 50)
	@Column(name = "FULL_NAME", length = 50)
	private String fullName;

	@Email
	@Length(max = 50)
	@Column(name = "EMAIL", nullable = false, unique = true, length = 50)
	private String email;

	@NotNull
	@Length(max = 40, min = 1)
	@Column(name = "PASSWORD", length = 40, nullable = false)
	private String password;

	@NotNull
	@Column(name = "ISACTIVE")
	private Boolean active = Boolean.FALSE;

	@Valid
	@Embedded
	@Column(name = "CREDIT")
	private Credit credit = new Credit();

	@OneToOne
	@JoinColumn(name = "CARD_ID")
	private CreditCard creditCard;

	@Length(max = 200)
	@Column(name = "BIOGRAPHY", length = 200)
	private String biography;

	@Email
	@Column(name = "PAYPAL")
	private String paypalMail;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ExpertRequest> expertRequests = new ArrayList<ExpertRequest>();

	@ManyToOne
	@JoinColumn(name = "ROLE_ID")
	private Role role;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Credit getCredit() {
		return credit;
	}

	public void setCredit(Credit credit) {
		this.credit = credit;
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
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
