package com.lnct.news.entities;

import java.util.Arrays;
import java.util.Date;

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
public class Reply {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "table-generator")
	@TableGenerator(name = "table-generator", table = "reply_ids", pkColumnName = "seq_id", valueColumnName = "seq_value")
	private Long replyId;
	@Lob
	private byte[] reply;
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "userId")
	private User user;
	private Long commentId;
	@Temporal(TemporalType.DATE)
	private Date replyDate;

	public Reply() {
		super();
	}

	
	public Reply(Long replyId, byte[] reply, Long commentId) {
		super();
		this.replyId = replyId;
		this.reply = reply;
		this.commentId = commentId;
	}


	public Reply(Long replyId, byte[] reply, User user, Long commentId, Date replyDate) {
		super();
		this.replyId = replyId;
		this.reply = reply;
		this.user = user;
		this.commentId = commentId;
		this.replyDate = replyDate;
	}

	public Long getReplyId() {
		return replyId;
	}

	public void setReplyId(Long replyId) {
		this.replyId = replyId;
	}

	public Date getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}

	public byte[] getReply() {
		return reply;
	}

	public void setReply(byte[] reply) {
		this.reply = reply;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	@Override
	public String toString() {
		return "Reply [replyId=" + replyId + ", reply=" + Arrays.toString(reply) + ", user=" + user + ", commentId="
				+ commentId + ", replyDate=" + replyDate + "]";
	}

}
