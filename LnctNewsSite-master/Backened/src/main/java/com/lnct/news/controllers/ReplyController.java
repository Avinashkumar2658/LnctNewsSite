package com.lnct.news.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lnct.news.dto.ReplyDto;
import com.lnct.news.entities.Reply;
import com.lnct.news.entities.User;
import com.lnct.news.response.ReplyResponse;
import com.lnct.news.services.ReplyService;
import com.lnct.news.services.UserService;
@CrossOrigin("http://lnctnewssite.s3-website.us-east-2.amazonaws.com")
@RestController
public class ReplyController {
	
	@Autowired
	ReplyService replyService;
	
	@Autowired
	UserService userService;
	
	@PostMapping("/reply")
	public void createReply(@RequestBody ReplyDto replyDto) {
		Reply reply = replyDto.get_reply();
		User user = userService.findByUserId(replyDto.getUserId());
		reply.setReplyDate(new Date());
		reply.setUser(user);
		replyService.createReply(reply);
	}
	
	@GetMapping("/reply/{commentId}")
	public List<ReplyResponse> findReply(@PathVariable Long commentId) {
		return replyService.findReply(commentId);
	}

}
