package com.lnct.news.dto;

import java.util.Date;

import com.lnct.news.entities.Comment;

public class CommentDto {
	
	private Long commentId;
	private String comment;
	private Long userId;
	private Long answerId;
	private Long largeNewsId;

	public CommentDto() {
		super();
	}

	public CommentDto(Long commentId, String comment, Long userId, Long answerId, Long largeNewsId) {
		super();
		this.commentId = commentId;
		this.comment = comment;
		this.userId = userId;
		this.answerId = answerId;
		this.largeNewsId = largeNewsId;
	}

	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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
	
	public Comment get_comment() {
		return new Comment(commentId, comment.getBytes(), answerId, largeNewsId, new Date());
	}

	@Override
	public String toString() {
		return "CommentDto [commentId=" + commentId + ", comment=" + comment + ", userId=" + userId + ", answerId="
				+ answerId + ", largeNewsId=" + largeNewsId + "]";
	}



}
