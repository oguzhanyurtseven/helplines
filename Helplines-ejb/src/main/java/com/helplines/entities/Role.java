package com.helplines.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "ROLES")
public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Length(max = 10, min = 1)
	@Column(name = "NAME", nullable = false, length = 10)
	private String name;

	@Column(name = "INFO")
	private String info;

	@OneToMany(mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Expert> experts = new ArrayList<Expert>();

	@OneToMany(mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<User> users = new ArrayList<User>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public List<Expert> getExperts() {
		return experts;
	}

	public void setExperts(List<Expert> experts) {
		this.experts = experts;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
