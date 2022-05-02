package com.lnct.news.dto;

import com.lnct.news.entities.Reply;

public class ReplyDto {

	private Long replyId;
	private String reply;
	private Long userId;
	private Long commentId;
	public ReplyDto() {
		super();
	}
	public ReplyDto(Long replyId, String reply, Long userId, Long commentId) {
		super();
		this.replyId = replyId;
		this.reply = reply;
		this.userId = userId;
		this.commentId = commentId;
		
	}
	
	public Long getReplyId() {
		return replyId;
	}
	public void setReplyId(Long replyId) {
		this.replyId = replyId;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUser(Long userId) {
		this.userId = userId;
	}
	public Long getCommentId() {
		return commentId;
	}
	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}
	
	
	public Reply get_reply() {
		return new Reply(replyId, reply.getBytes(), commentId);
	}
	@Override
	public String toString() {
		return "ReplyDto [replyId=" + replyId + ", reply=" + reply + ", userId=" + userId + ", commentId=" + commentId
				 + "]";
	}
		
	
}
