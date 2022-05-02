package com.lnct.news.dto;

public class QuestionDto {
	private Long questionId;
	private Long userId;
	private String question;

	public QuestionDto() {
		super();

	}

	public QuestionDto(Long questionId, Long userId, String question) {
		super();
		this.questionId = questionId;
		this.userId = userId;
		this.question = question;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "QuestionDto [questionId=" + questionId + ", userId=" + userId + ", question=" + question + "]";
	}

}
