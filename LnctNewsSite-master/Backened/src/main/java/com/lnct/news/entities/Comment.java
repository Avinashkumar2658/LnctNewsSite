package com.lnct.news.entities;

import java.util.Arrays;
import java.util.Date;

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
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "table-generator")
	@TableGenerator(name = "table-generator", table = "comments_ids", pkColumnName = "seq_id", valueColumnName = "seq_value")
	private Long commentId;
	private byte[] comment;
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "userId")
	private User user;
	private Long answerId;
	private Long largeNewsId;
	@Temporal(TemporalType.DATE)
	private Date commentDate;
	public Comment() {
		super();
	}
	public Comment(Long commentId, byte[] comment, Long answerId, Long largeNewsId, Date commentDate) {
		super();
		this.commentId = commentId;
		this.comment = comment;
		this.answerId = answerId;
		this.largeNewsId = largeNewsId;
		this.commentDate = commentDate;
	}
	public Long getCommentId() {
		return commentId;
	}
	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}
	public byte[] getComment() {
		return comment;
	}
	public void setComment(byte[] comment) {
		this.comment = comment;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Long getAnswerId() {
		return answerId;
	}
	public void setAnswerId(Long answerId) {
		this.answerId = answerId;
	}
	public Long getLargeNewsId() {
		return largeNewsId;
	}
	public void setLargeNewsId(Long largeNewsId) {
		this.largeNewsId = largeNewsId;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", comment=" + Arrays.toString(comment) + ", user=" + user
				+ ", answerId=" + answerId + ", largeNewsId=" + largeNewsId + ", commentDate=" + commentDate + "]";
	}
	
	
}
