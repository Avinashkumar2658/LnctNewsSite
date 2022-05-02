package com.lnct.news.response;

import java.util.Date;

public class NewsResponse {

	private Long newsId;
	private String newsHeading;
	private String detail;
	private Date startDate;
	private Date endDate;
	private Long categoryId;
	private Long userId;
	private String user_name;
	private byte[] user_profile_photo;
	private String user_role;
	private Date createDate;
	private String url;
	private byte[] photo;

	public NewsResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NewsResponse(Long newsId, String newsHeading, String detail, Date startDate, Date endDate, Long categoryId,
			Long userId, String user_name, byte[] user_profile_photo, String user_role, Date createDate, String url,
			byte[] photo) {
		super();
		this.newsId = newsId;
		this.newsHeading = newsHeading;
		this.detail = detail;
		this.startDate = startDate;
		this.endDate = endDate;
		this.categoryId = categoryId;
		this.userId = userId;
		this.user_name = user_name;
		this.user_profile_photo = user_profile_photo;
		this.user_role = user_role;
		this.createDate = createDate;
		this.url = url;
		this.photo = photo;
	}

	public NewsResponse(Long newsId, String newsHeading, String detail, Date startDate, Date endDate, Long categoryId,
			Date createDate, String url, byte[] photo) {
		super();
		this.newsId = newsId;
		this.newsHeading = newsHeading;
		this.detail = detail;
		this.startDate = startDate;
		this.endDate = endDate;
		this.categoryId = categoryId;
		this.createDate = createDate;
		this.url = url;
		this.photo = photo;
	}

	public Long getNewsId() {
		return newsId;
	}

	public void setNewsId(Long newsId) {
		this.newsId = newsId;
	}

	public String getNewsHeading() {
		return newsHeading;
	}

	public void setNewsHeading(String newsHeading) {
		this.newsHeading = newsHeading;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public byte[] getUser_profile_photo() {
		return user_profile_photo;
	}

	public void setUser_profile_photo(byte[] user_profile_photo) {
		this.user_profile_photo = user_profile_photo;
	}

	public String getUser_role() {
		return user_role;
	}

	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

}
