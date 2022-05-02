package com.lnct.news.response;

import java.util.Date;

public class AnswerResponse {
	
	private Long answerId;
	private String answer;
	private Date createDate;
	private UserResponse userResponse;
	private Long questionId;
	public AnswerResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AnswerResponse(Long answerId, String answer, Date createDate, UserResponse userResponse , Long questionId) {
		super();
		this.answerId = answerId;
		this.answer = answer;
		this.createDate = createDate;
		this.userResponse = userResponse;
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
	public  UserResponse getUser() {
		return userResponse;
	}
	public void setUserResponse(UserResponse userResponse) {
		this.userResponse = userResponse;
	}
	public Long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}
	@Override
	public String toString() {
		return "AnswerResponseDto [answerId=" + answerId + ", answer=" + answer + ", createDate=" + createDate + ", userResponse="
				+ userResponse + ", questionId=" + questionId + "]";
	}
	
	
}
