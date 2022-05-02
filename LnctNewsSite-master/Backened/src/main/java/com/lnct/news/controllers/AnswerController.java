package com.lnct.news.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lnct.news.dto.AnswerDto;
import com.lnct.news.entities.Answer;
import com.lnct.news.entities.User;
import com.lnct.news.response.AnswerResponse;
import com.lnct.news.services.AnswerService;
import com.lnct.news.services.UserService;
@CrossOrigin("http://lnctnewssite.s3-website.us-east-2.amazonaws.com")
@RestController
public class AnswerController {
	
	
	@Autowired
	AnswerService answerService;
	
	@Autowired
	UserService userService;
	
	@PostMapping("createAnswer")
	public Answer createAnswer(@RequestBody AnswerDto answerDto) {
		Answer answer = new Answer();
		answer = answerDto.get_answer();
		User user = userService.findByUserId(answerDto.getUserId());
		answer.setUser(user);
		return answerService.createAnswer(answer);
	
	}
	
	
	@GetMapping("/getAllAnswer/{questionId}")
	public List<AnswerResponse> getAllAnswerByQuestionId(@PathVariable Long   questionId) {
		List<AnswerResponse> ansq = answerService.getAllAnswerByQuestionId(questionId);
		return ansq;
	}
	
	
}
