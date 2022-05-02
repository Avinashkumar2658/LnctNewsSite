package com.lnct.news.response;

import java.util.Date;

public class ReplyResponse {
	private Long replyId;
	private Long userId;
	private byte[] userImage;
	private String userName;
	private String present_profile;
	private String reply;
	private Date replyDate;
	
	public ReplyResponse() {
		super();
	}

	public ReplyResponse(Long replyId, Long userId, byte[] userImage, String userName, String present_profile,
			String reply, Date replyDate) {
		super();
		this.replyId = replyId;
		this.userId = userId;
		this.userImage = userImage;
		this.userName = userName;
		this.present_profile = present_profile;
		this.reply = reply;
		this.replyDate = replyDate;
	}

	public Long getReplyId() {
		return replyId;
	}

	public void setReplyId(Long replyId) {
		this.replyId = replyId;
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

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public Date getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}

	
	
	
	
	
}
