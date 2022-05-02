package com.lnct.news.dto;

import java.util.Date;

import com.lnct.news.entities.Answer;

public class AnswerDto {
	
	private Long answerId;
	private String answer;
	private Date createDate;
	private Long userId;
	private Long questionId;
	public AnswerDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AnswerDto(Long answerId, String answer, Date createDate, Long userId, Long questionId) {
		super();
		this.answerId = answerId;
		this.answer = answer;
		this.createDate = createDate;
		this.userId = userId;
		this.questionId = questionId;
	}
	public Long getAnswerId() {
		return answerId;
	}
	public void setAnswerId(Long answerId) {
		this.answerId = answerId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public  Long getUserId() {
		return userId;
	}
	public void setUser(Long  userId) {
		this.userId = userId;
	}
	public Long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}
	public Answer get_answer() {
		return new Answer(answerId, answer.getBytes(), createDate,  questionId);
	}
	@Override
	public String toString() {
		return "AnswerDto [answerId=" + answerId + ", answer=" + answer + ", createDate=" + createDate + ", userId="
				+ userId + ", questionId=" + questionId + "]";
	}
	
	
}
