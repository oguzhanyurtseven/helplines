package com.helplines.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class AuditBase {

	@Column(name = "CREATE_DATE")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date createDate;

	@Column(name = "UPDATE_DATE")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date updateDate;

	@Column(name = "CREATE_USER")
	private String createUser;

	@Column(name = "UPDATE_USER")
	private String updateUser;

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

}
