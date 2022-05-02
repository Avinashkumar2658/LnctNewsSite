package com.lnct.news.response;

import java.util.Date;

public class ResponseFile {
	private long id;
	private String largeNewsHeading;
	private String detail;
	private String file_name;
	private Long user_id;
	private String user_name;
	private byte[] profile_photo;
	private String present_profile;
	private Date date;
	private String otherWebsiteLink;
	private String url;
	private String type;
	private long size;

	public ResponseFile() {
		super();
	}

	public ResponseFile(long id, String largeNewsHeading, String detail, String file_name, Long user_id,
			String user_name, byte[] profile_photo, String present_profile, Date date, String otherWebsiteLink,
			String url, String type, long size) {
		super();
		this.id = id;
		this.largeNewsHeading = largeNewsHeading;
		this.detail = detail;
		this.file_name = file_name;
		this.user_id = user_id;
		this.user_name = user_name;
		this.profile_photo = profile_photo;
		this.present_profile = present_profile;
		this.date = date;
		this.otherWebsiteLink = otherWebsiteLink;
		this.url = url;
		this.type = type;
		this.size = size;
	}

	public ResponseFile(long id, String largeNewsHeading, String detail, String file_name, Date date,
			String otherWebsiteLink, String url, String type, long size) {
		super();
		this.id = id;
		this.largeNewsHeading = largeNewsHeading;
		this.detail = detail;
		this.file_name = file_name;
		this.date = date;
		this.otherWebsiteLink = otherWebsiteLink;
		this.url = url;
		this.type = type;
		this.size = size;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLargeNewsHeading() {
		return largeNewsHeading;
	}

	public void setLargeNewsHeading(String largeNewsHeading) {
		this.largeNewsHeading = largeNewsHeading;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public byte[] getProfile_photo() {
		return profile_photo;
	}

	public void setProfile_photo(byte[] profile_photo) {
		this.profile_photo = profile_photo;
	}

	public String getPresent_profile() {
		return present_profile;
	}

	public void setPresent_profile(String present_profile) {
		this.present_profile = present_profile;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getOtherWebsiteLink() {
		return otherWebsiteLink;
	}

	public void setOtherWebsiteLink(String otherWebsiteLink) {
		this.otherWebsiteLink = otherWebsiteLink;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

}
