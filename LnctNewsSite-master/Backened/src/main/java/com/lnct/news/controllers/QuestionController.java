package com.lnct.news.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lnct.news.dto.QuestionDto;
import com.lnct.news.services.QuestionService;

@CrossOrigin("http://lnctnewssite.s3-website.us-east-2.amazonaws.com")
@RestController
public class QuestionController {
	@Autowired
	QuestionService questionService;
	
	@PostMapping("/crateQuestion")
	public void createQuestion(@RequestBody QuestionDto question) {
		questionService.createQuestion(question);
	}
	
	
	
	@GetMapping("/getAllQuestion")
	public List<QuestionDto> getAllQuestion() {
		List<QuestionDto> question = questionService.findAllQuestion();
		return question;
	}

}
