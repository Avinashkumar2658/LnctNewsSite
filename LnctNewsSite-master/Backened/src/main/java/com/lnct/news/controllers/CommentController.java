package com.lnct.news.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lnct.news.dto.CommentDto;
import com.lnct.news.entities.Comment;
import com.lnct.news.entities.User;
import com.lnct.news.response.CommentResponse;
import com.lnct.news.services.CommentService;
import com.lnct.news.services.UserService;
@CrossOrigin("http://lnctnewssite.s3-website.us-east-2.amazonaws.com")
@RestController
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	@Autowired
	UserService userService;
	
	@PostMapping("/createComment")
	public void createComment(@RequestBody CommentDto commentDto) {
		Comment comment = commentDto.get_comment();
		User userData = userService.findByUserId(commentDto.getUserId());
		comment.setUser(userData);
		commentService.createComment(comment);
	}
	
	
	@PostMapping("/createLargeNewsComment")
	public void createLargeNewsComment(@RequestBody CommentDto commentDto) {
		Comment comment = commentDto.get_comment();
		User userData = userService.findByUserId(commentDto.getUserId());
		comment.setUser(userData);
		commentService.createComment(comment);
	}
	@GetMapping("/getAnswerComment/{answerId}")
	public List<CommentResponse> findAnswerComment(@PathVariable Long answerId) {
		
		return commentService.findComment(answerId);
	}
	
	@GetMapping("/getComment/{largeNewsId}")
	public List<CommentResponse> findLargeNewsComment(@PathVariable Long largeNewsId) {
		
		return commentService.findLargeNewsComment(largeNewsId);
	}

}
