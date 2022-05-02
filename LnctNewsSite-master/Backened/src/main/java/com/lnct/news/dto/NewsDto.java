package com.lnct.news.dto;

public class NewsDto {

	private String newsId;
	private String newsHeading;
	private String detail;
	private String startDate;
	private String endDate;
	private String categoryId;
	private String userId;
	private String url;

	

	public NewsDto(String newsId, String newsHeading, String detail, String startDate, String endDate,
			String categoryId, String userId, String url) {
		super();
		this.newsId = newsId;
		this.newsHeading = newsHeading;
		this.detail = detail;
		this.startDate = startDate;
		this.endDate = endDate;
		this.categoryId = categoryId;
		this.userId = userId;
		this.url = url;
	}

	public String getNewsId() {
		return newsId;
	}

	public void setNewsId(String newsId) {
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

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	

}
