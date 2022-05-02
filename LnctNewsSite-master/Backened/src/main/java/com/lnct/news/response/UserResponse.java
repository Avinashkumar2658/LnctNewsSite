package com.lnct.news.response;

import java.util.Arrays;

import javax.persistence.Lob;

public class UserResponse {
	private Long userId;
	private String userName;
	private String enrollmentNo;
	private String password;
	private String emailId;
	private int userMode;
	private boolean isAdmin;
	private String someThingAboutYourSelf;
	private String presentProfile;
	private String inspirationWord;
	@Lob
	private byte[] profilePhoto;

	public UserResponse() {
		super();
	}

	public UserResponse(Long userId, String userName, String enrollmentNo, String password, String emailId,
			int userMode, boolean isAdmin, String someThingAboutYourSelf, String presentProfile, String inspirationWord,
			byte[] profilePhoto) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.enrollmentNo = enrollmentNo;
		this.password = password;
		this.emailId = emailId;
		this.userMode = userMode;
		this.isAdmin = isAdmin;
		this.someThingAboutYourSelf = someThingAboutYourSelf;
		this.presentProfile = presentProfile;
		this.inspirationWord = inspirationWord;
		this.profilePhoto = profilePhoto;
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

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
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

	public byte[] getProfilePhoto() {
		return profilePhoto;
	}

	public void setProfilePhoto(byte[] profilePhoto) {
		this.profilePhoto = profilePhoto;
	}

	@Override
	public String toString() {
		return "UserResponse [userId=" + userId + ", userName=" + userName + ", enrollmentNo=" + enrollmentNo
				+ ", password=" + password + ", emailId=" + emailId + ", userMode=" + userMode + ", isAdmin=" + isAdmin
				+ ", someThingAboutYourSelf=" + someThingAboutYourSelf + ", presentProfile=" + presentProfile
				+ ", inspirationWord=" + inspirationWord + ", profilePhoto=" + Arrays.toString(profilePhoto) + "]";
	}

}
