package com.lnct.news.security;

public class AuthenticationBean {

	private Long userId;
	private boolean isAdmin;
	private boolean isEnabled;

	public AuthenticationBean() {
		super();

	}

	public AuthenticationBean(Long userId, boolean isAdmin, boolean isEnabled) {
		super();
		this.userId = userId;
		this.isAdmin = isAdmin;
		this.isEnabled = isEnabled;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	@Override
	public String toString() {
		return "AuthenticationBean [userId=" + userId + ", isAdmin=" + isAdmin + ", isEnabled=" + isEnabled + "]";
	}

}
