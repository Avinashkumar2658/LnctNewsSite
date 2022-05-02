package com.lnct.news.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class LargeNews {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "table-generator")
	@TableGenerator(name = "table-generator", table = "LargeNews_ids", pkColumnName = "seq_id", valueColumnName = "seq_value")
	@Column(name = "news_id")
	private Long largeNewsId;
	@Column(name = "heading")
	private String largeNewsHeading;
	private String detail;
	private int year;
	private int semester;
	private Long categoryId;
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "userId")
	private User user;
	private String url;
	@Temporal(TemporalType.DATE)
	private Date createDate;
	private FileDB file;

	public LargeNews() {
		super();
	}

	public LargeNews(Long largeNewsId, String largeNewsHeading, String detail, int year, int semester, Long categoryId,
			User user, String url, Date createDate, FileDB file) {
		super();
		this.largeNewsId = largeNewsId;
		this.largeNewsHeading = largeNewsHeading;
		this.detail = detail;
		this.year = year;
		this.semester = semester;
		this.categoryId = categoryId;
		this.user = user;
		this.url = url;
		this.createDate = createDate;
		this.file = file;
	}

	public Long getLargeNewsId() {
		return largeNewsId;
	}

	public void setLargeNewsId(Long largeNewsId) {
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

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public FileDB getFile() {
		return file;
	}

	public void setFile(FileDB file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "LargeNews [largeNewsId=" + largeNewsId + ", largeNewsHeading=" + largeNewsHeading + ", detail=" + detail
				+ ", year=" + year + ", semester=" + semester + ", categoryId=" + categoryId + ", user=" + user
				+ ", url=" + url + ", createDate=" + createDate + ", file=" + file + "]";
	}

}
