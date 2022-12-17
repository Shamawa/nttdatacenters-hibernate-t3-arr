package com.nttdata.nttdatatallermvnarr.persistence;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

/**
 * Entidad Abstracta
 * 
 * @author Alexandra Rodriguez
 *
 */

@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

	/** SERIAL VERSION */
	private static final long serialVersionUID = 1L;

	/** User de creacion */
	private String createUser;

	/** Date create */
	private String createDate;

	// Getters and Setters

	@Column(name = "C_CREATE_USER")
	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	@Column(name = "C_CREATE_DATE")
	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

}
