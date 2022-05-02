package com.lnct.news.entities;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ConfirmationToken {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long tokenid;
	private String confirmationToken;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	
	@JoinColumn(name = "userId", referencedColumnName = "userId")
	private Long userId;

	public ConfirmationToken() {
	}

	public ConfirmationToken(Long userId) {		
		setUserId(userId);		
		createdDate = new Date();
		confirmationToken = UUID.randomUUID().toString();

	}

	public String getConfirmationToken() {
		return confirmationToken;
	}

	public void setConfirmationToken(String confirmationToken) {
		this.confirmationToken = confirmationToken;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public long getTokenid() {
		return tokenid;
	}

	public void setTokenid(long tokenid) {
		this.tokenid = tokenid;
	}

	@Override
	public String toString() {
		return "ConfirmationToken [tokenid=" + tokenid + ", confirmationToken=" + confirmationToken + ", createdDate="
				+ createdDate + ", userId=" + userId + "]";
	}
	
}
