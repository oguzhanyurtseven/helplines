package com.helplines.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "EXPERTS")
public class Expert extends User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
