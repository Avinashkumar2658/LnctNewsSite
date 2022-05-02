package com.lnct.news.dto;

import java.io.UnsupportedEncodingException;

import com.lnct.news.entities.User;

public class UserDto {
	private String userId;
	private String userName;
	private String enrollmentNo;
	private String password;
	private String emailId;
	private int userMode;
	private boolean enabled;
	private boolean isAdmin;
	private String someThingAboutYourSelf;
	private String presentProfile;
	private String inspirationWord;

	public UserDto() {
		super();
	}

	public UserDto(String userId, String userName, String enrollmentNo, String emailId, String someThingAboutYourSelf,
			String presentProfile, String inspirationWord) {
//		super();
		this.userId = userId;
		this.userName = userName;
		this.enrollmentNo = enrollmentNo;
		this.emailId = emailId;
		this.someThingAboutYourSelf = someThingAboutYourSelf;
		this.presentProfile = presentProfile;
		this.inspirationWord = inspirationWord;
	}

	public UserDto(String userId, String userName, String enrollmentNo, String password, String emailId, int userMode, boolean enabled,
			boolean isAdmin, String someThingAboutYourSelf, String presentProfile,
			String inspirationWord) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.enrollmentNo = enrollmentNo;
		this.password = password;
		this.emailId = emailId;
		this.userMode = userMode;
		this.isAdmin = isAdmin;
		this.enabled = enabled;
		this.someThingAboutYourSelf = someThingAboutYourSelf;
		this.presentProfile = presentProfile;
		this.inspirationWord = inspirationWord;
	}

	

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
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

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getSomeThingAboutYourSelf() {
		return someThingAboutYourSelf;
	}

	public void setSomeThingAboutYourSelf(String someThingAboutYourSelf) {
		this.someThingAboutYourSelf = someThingAboutYourSelf;
	}

	public String getPresentProfile() {
		return presentProfile;
	}

	public void setPresentProfile(String presentProfile) {
		this.presentProfile = presentProfile;
	}

	public String getInspirationWord() {
		return inspirationWord;
	}

	public void setInspirationWord(String inspirationWord) {
		this.inspirationWord = inspirationWord;
	}

	public User getUserDetail() throws UnsupportedEncodingException {

		return new User(Long.parseLong(String.valueOf(userId).replace("\"", "")), userName.replace("\"", ""),
				enrollmentNo.replace("\"", ""), String.valueOf(emailId).replace("\"", ""),
				someThingAboutYourSelf.replace("\"", "").getBytes("UTF-8"), presentProfile.replace("\"", "").getBytes(),
				inspirationWord.replace("\"", "").getBytes());
	}

	@Override
	public String toString() {
		return "UserDto [userId=" + userId + ", userName=" + userName + ", enrollmentNo=" + enrollmentNo + ", password="
				+ password + ", emailId=" + emailId + ", userMode=" + userMode + ", isAdmin=" + isAdmin + ", enabled="
				+ enabled + ", someThingAboutYourSelf=" + someThingAboutYourSelf + ", presentProfile=" + presentProfile
				+ ", inspirationWord=" + inspirationWord + "]";
	}

	

}
