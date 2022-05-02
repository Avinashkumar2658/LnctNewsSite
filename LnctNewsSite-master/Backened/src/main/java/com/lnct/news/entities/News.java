package com.lnct.news.entities;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class News {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "table-generator")
	@TableGenerator(name = "table-generator", table = "News_ids", pkColumnName = "seq_id", valueColumnName = "seq_value")
	private Long newsId;
	@Column(name = "heading")
	private String newsHeading;
	private String detail;
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@Temporal(TemporalType.DATE)
	private Date endDate;
	private Long categoryId;
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "userId")
	private User user;
	@Temporal(TemporalType.DATE)
	private Date createDate;
	private String url;
	@Lob
	private byte[] photo;

	public News() {
		super();

	}

	public News(Long newsId, String newsHeading, String detail, Date startDate, Date endDate, Long categoryId,
			User user, String url) {
		super();
		this.newsId = newsId;
		this.newsHeading = newsHeading;
		this.detail = detail;
		this.startDate = startDate;
		this.endDate = endDate;
		this.categoryId = categoryId;
		this.user = user;
		this.url = url;
	}

	public News(Long newsId, String newsHeading, String detail, Date startDate, Date endDate, Long categoryId,
			User user, String url, byte[] photo) {
		super();
		this.newsId = newsId;
		this.newsHeading = newsHeading;
		this.detail = detail;
		this.startDate = startDate;
		this.endDate = endDate;
		this.categoryId = categoryId;
		this.user = user;
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

	public String getDetails() {
		return detail;
	}

	public void setNews(String detail) {
		this.detail = detail;
	}

	public Date getStartDate() {
		return startDate;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "News [newsId=" + newsId + ", newsHeading=" + newsHeading + ", detail=" + detail + ", startDate="
				+ startDate + ", endDate=" + endDate + ", categoryId=" + categoryId + ", user=" + user
				+ ", createDate=" + createDate + ", url=" + url + ", photo=" + Arrays.toString(photo) + "]";
	}

}
