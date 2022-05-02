package com.lnct.news.entities;

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
public class Answer {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "table-generator")
	@TableGenerator(name = "table-generator", table = "answers_ids", pkColumnName = "seq_id", valueColumnName = "seq_value")
	private Long answerId;
	@Lob
	private byte[] answer;
	@Temporal(TemporalType.DATE)
	private Date createDate;
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "userId")
	private User user;
	public Long questionId;

	public Answer() {
		super();
	}

	public Answer(Long answerId, byte[] answer, Date createDate, User user, Long questionId) {
		super();
		this.answerId = answerId;
		this.answer = answer;
		this.user = user;
		this.questionId = questionId;
		this.createDate = createDate;
	}

	public Answer(Long answerId, byte[] answer, Date createDate, Long questionId) {
		super();
		this.answerId = answerId;
		this.answer = answer;
		this.createDate = createDate;
		this.questionId = questionId;
	}

	public Long getAnswerId() {
		return answerId;
	}

	public void setAnswerId(Long answerId) {
		this.answerId = answerId;
	}

	public byte[] getAnswer() {
		return answer;
	}

	public void setAnswer(byte[] answer) {
		this.answer = answer;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

}
