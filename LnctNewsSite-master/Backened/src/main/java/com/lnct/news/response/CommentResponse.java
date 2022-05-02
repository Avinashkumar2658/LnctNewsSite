package com.lnct.news.response;

import java.util.Date;

public class CommentResponse {
	private Long commentId;
	private Long userId;
	private byte[] userImage;
	private String userName;
	private String present_profile;
	private String comment;
	private Date commentDate;

	public CommentResponse() {
		super();
	}

	public CommentResponse(Long commentId, Long userId, byte[] userImage, String userName, String present_profile,
			String comment, Date commentDate) {
		super();
		this.commentId = commentId;
		this.userId = userId;
		this.userImage = userImage;
		this.userName = userName;
		this.present_profile = present_profile;
		this.comment = comment;
		this.commentDate = commentDate;
	}

	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public byte[] getUserImage() {
		return userImage;
	}

	public void setUserImage(byte[] userImage) {
		this.userImage = userImage;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPresent_profile() {
		return present_profile;
	}

	public void setPresent_profile(String present_profile) {
		this.present_profile = present_profile;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	

	

}
