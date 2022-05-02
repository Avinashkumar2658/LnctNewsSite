package com.lnct.news.dto;

import com.lnct.news.entities.User;

public class UserRegistrationDto {
	private Long userId;
	private String userName;
	private String enrollmentNo;
	private String password;
	private String emailId;
	private int userMode;
	private boolean enabled;
	private boolean isAdmin;
	public UserRegistrationDto() {
		super();
	}
	
	public UserRegistrationDto(Long userId, String userName, String enrollmentNo, String password, String emailId,
			int userMode, boolean enabled, boolean isAdmin) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.enrollmentNo = enrollmentNo;
		this.password = password;
		this.emailId = emailId;
		this.userMode = userMode;
		this.enabled = enabled;
		this.isAdmin = isAdmin;
		
	}

	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEnrollmentNo() {
		return enrollmentNo;
	}

	public void setEnrollmentNo(String enrollmentNo) {
		this.enrollmentNo = enrollmentNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public int getUserMode() {
		return userMode;
	}

	public void setUserMode(int userMode) {
		this.userMode = userMode;
	}

	public boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public User getUser() {
		return new User(userId, userName, enrollmentNo, password, emailId, userMode, enabled, isAdmin);
	}

	@Override
	public String toString() {
		return "UserRegistrationDto [userId=" + userId + ", userName=" + userName + ", enrollmentNo=" + enrollmentNo
				+ ", password=" + password + ", emailId=" + emailId + ", userMode=" + userMode + ", isAdmin=" + isAdmin
				+ ", enabled=" + enabled + "]";
	}
	
	
	
}
