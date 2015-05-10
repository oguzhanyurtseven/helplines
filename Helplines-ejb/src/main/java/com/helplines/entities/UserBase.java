package com.helplines.entities;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
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

}
