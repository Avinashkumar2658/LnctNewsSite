package com.lnct.news.entities;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	private String userName;
    @Column(unique = true)
	private String enrollmentNo;
	private String password;
    @Column(unique = true)
	private String emailId;
	private int userMode;
	private boolean enabled;
	private boolean isAdmin;
	private byte[] someThingAboutYourSelf;
	private byte[] presentProfile;
	private byte[] inspirationWord;
	@Lob
	private byte[] profilePhoto;

	public User() {
		super();
	}

	public User(Long userId, String userName, String enrollmentNo, String password, String emailId) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.enrollmentNo = enrollmentNo;
		this.password = password;
		this.emailId = emailId;
	}

	public User(Long userId, String userName, String enrollmentNo, String emailId, byte[] someThingAboutYourSelf,
			byte[] presentProfile, byte[] inspirationWord) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.enrollmentNo = enrollmentNo;
		this.emailId = emailId;
		this.someThingAboutYourSelf = someThingAboutYourSelf;
		this.presentProfile = presentProfile;
		this.inspirationWord = inspirationWord;
	}

	public User(Long userId, String userName, String enrollmentNo, String password, String emailId, int userMode,
		boolean enabled, boolean isAdmin, byte[] someThingAboutYourSelf, byte[] presentProfile, byte[] inspirationWord,
		byte[] profilePhoto) {
	super();
	this.userId = userId;
	this.userName = userName;
	this.enrollmentNo = enrollmentNo;
	this.password = password;
	this.emailId = emailId;
	this.userMode = userMode;
	this.enabled = enabled;
	this.isAdmin = isAdmin;
	this.someThingAboutYourSelf = someThingAboutYourSelf;
	this.presentProfile = presentProfile;
	this.inspirationWord = inspirationWord;
	this.profilePhoto = profilePhoto;
}

	public User(Long userId, String userName, String enrollmentNo, String password, String emailId, int userMode, boolean enabled,
			boolean isAdmin) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.enrollmentNo = enrollmentNo;
		this.password = password;
		this.emailId = emailId;
		this.userMode = userMode;
		this.isAdmin = isAdmin;
		this.enabled = enabled;
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

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public byte[] getSomeThingAboutYourSelf() {
		return someThingAboutYourSelf;
	}

	public void setSomeThingAboutYourSelf(byte[] someThingAboutYourSelf) {
		this.someThingAboutYourSelf = someThingAboutYourSelf;
	}

	public byte[] getPresentProfile() {
		return presentProfile;
	}

	public void setPresentProfile(byte[] presentProfile) {
		this.presentProfile = presentProfile;
	}

	public byte[] getInspirationWord() {
		return inspirationWord;
	}

	public void setInspirationWord(byte[] inspirationWord) {
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
		return "User [userId=" + userId + ", userName=" + userName + ", enrollmentNo=" + enrollmentNo + ", password="
				+ password + ", emailId=" + emailId + ", userMode=" + userMode + ", enabled=" + enabled + ", isAdmin="
				+ isAdmin + ", someThingAboutYourSelf=" + Arrays.toString(someThingAboutYourSelf) + ", presentProfile="
				+ Arrays.toString(presentProfile) + ", inspirationWord=" + Arrays.toString(inspirationWord)
				+ ", profilePhoto=" + Arrays.toString(profilePhoto) + "]";
	}



}
