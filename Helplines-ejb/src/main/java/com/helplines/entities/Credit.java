package com.helplines.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;

@Embeddable
@MappedSuperclass
public class Credit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BigDecimal credit;

	public Credit() {
		credit = BigDecimal.ZERO;
	}

	public Credit(Credit value) {
		this.credit = value.getCredit();
	}

	public Credit(BigDecimal value) {
		this.credit = value;
	}

	public void clearCredit() {
		this.credit = BigDecimal.ZERO;
	}

	@Column(name = "CREDIT", precision = 19, scale = 2)
	public BigDecimal getCredit() {
		return credit;
	}

	public void setValue(BigDecimal value) {
		this.credit = value;
	}

	public void add(Credit value) {
		credit = credit.add(value.getCredit());
	}

}
