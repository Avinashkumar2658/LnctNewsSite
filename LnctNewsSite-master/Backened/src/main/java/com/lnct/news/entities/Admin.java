package com.lnct.news.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long adminId;
	private String adminRegisteredId;
	private String adminName;

	public Admin() {
		super();
	}

	public Admin(Long adminId, String adminRegisteredId, String adminName) {
		super();
		this.adminId = adminId;
		this.adminRegisteredId = adminRegisteredId;
		this.adminName = adminName;
	}

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	public String getAdminRegisteredId() {
		return adminRegisteredId;
	}

	public void setAdminRegisteredId(String adminRegisteredId) {
		this.adminRegisteredId = adminRegisteredId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminRegisteredId=" + adminRegisteredId + ", adminName=" + adminName
				+ "]";
	}

}
