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

	private BigDecimal value;

	public Credit() {
		value = BigDecimal.ZERO;
	}

	public Credit(Credit credit) {
		this.value = credit.getValue();
	}

	public Credit(BigDecimal value) {
		this.value = value;
	}

	public void clearCredit() {
		this.value = BigDecimal.ZERO;
	}

	@Column(name = "VAL", precision = 19, scale = 2)
	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public void add(Credit credit) {
		value = value.add(credit.getValue());
	}

}
