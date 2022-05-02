package com.lnct.news.entities;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.TableGenerator;

@Entity
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "table-generator")
	@TableGenerator(name = "table-generator", table = "Question_id", pkColumnName = "seq_id", valueColumnName = "seq_value")
	private Long questionId ;
    private Long userId ;
    @Lob
    private byte[] question;
	public Question() {
		super();
	}
	public Question(Long questionId, Long userId, byte[] question) {
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
	public byte[] getQuestion() {
		return question;
	}
	public void setQuestion(byte[] question) {
		this.question = question;
	}
	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", userId=" + userId + ", question=" + Arrays.toString(question)
				+ "]";
	}
	
    
    

}
