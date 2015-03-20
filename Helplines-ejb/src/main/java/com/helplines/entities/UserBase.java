package com.helplines.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

@MappedSuperclass
public class UserBase {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Length(max = 10, min = 1)
	@Column(name = "USER_NAME", length = 10, nullable = false, unique = true)
	private String userName;

	@Length(max = 50)
	@Column(name = "FULL_NAME", length = 50)
	private String fullName;

	@Email
	@Column(name = "EMAIL")
	private String email;

	@NotNull
	@Length(max = 40, min = 1)
	@Column(name = "PASSWORD", length = 40, nullable = false)
	private Long password;

	@Length(max = 30)
	@Column(name = "COMPANY_NAME", length = 30)
	private String company;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "COMPANY_TYPE")
	private CompanyType companyType = CompanyType.None;

	@NotNull
	@Length(max = 200)
	@Column(name = "LANGUAGES", length = 200)
	private String interestOfLanguages;

	@NotNull
	@Length(max = 1, min = 1)
	@Column(name = "EXPERIENCE", length = 1)
	private Character programmingExperience;

	@Column(name = "ISACTIVE")
	private Boolean active = Boolean.FALSE;

	@Valid
	@Embedded
	@Column(name = "CREDIT")
	private Credit credit = new Credit();

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CreditCard> creditCards = new ArrayList<CreditCard>();

	public Long getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public String getFullName() {
		return fullName;
	}

	public String getEmail() {
		return email;
	}

	public Long getPassword() {
		return password;
	}

	public String getCompany() {
		return company;
	}

	public CompanyType getCompanyType() {
		return companyType;
	}

	public String getInterestOfLanguages() {
		return interestOfLanguages;
	}

	public Character getProgrammingExperience() {
		return programmingExperience;
	}

	public Boolean getActive() {
		return active;
	}

	public Credit getCredit() {
		return credit;
	}

	public List<CreditCard> getCreditCards() {
		return creditCards;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(Long password) {
		this.password = password;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void setCompanyType(CompanyType companyType) {
		this.companyType = companyType;
	}

	public void setInterestOfLanguages(String interestOfLanguages) {
		this.interestOfLanguages = interestOfLanguages;
	}

	public void setProgrammingExperience(Character programmingExperience) {
		this.programmingExperience = programmingExperience;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public void setCredit(Credit credit) {
		this.credit = credit;
	}

	public void setCreditCards(List<CreditCard> creditCards) {
		this.creditCards = creditCards;
	}

}
