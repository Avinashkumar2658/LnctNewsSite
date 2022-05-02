package com.lnct.news.dto;

public class LargeNewsDto {
	private String largeNewsId;
	private String largeNewsHeading;
	private String detail;
	private String year;
	private String semester;
	private String categoryId;
	private String userId;
	private String url;

	public LargeNewsDto() {
		super();

	}

	public LargeNewsDto(String largeNewsId, String largeNewsHeading, String detail, String year, String semester,
			String categoryId, String userId, String url) {
		super();
		this.largeNewsId = largeNewsId;
		this.largeNewsHeading = largeNewsHeading;
		this.detail = detail;
		this.year = year;
		this.semester = semester;
		this.categoryId = categoryId;
		this.userId = userId;
		this.url = url;
	}

	public String getLargeNewsId() {
		return largeNewsId;
	}

	public void setLargeNewsId(String largeNewsId) {
		this.largeNewsId = largeNewsId;
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

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
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
