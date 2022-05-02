package com.lnct.news.services;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lnct.news.daos.ReplyDao;
import com.lnct.news.entities.Reply;
import com.lnct.news.entities.User;
import com.lnct.news.response.ReplyResponse;

@Service
public class ReplyService {
	@Autowired
	ReplyDao replyRepository;
	
	public Reply createReply(Reply reply) {
		return replyRepository.save(reply);
	}
	
	public List<ReplyResponse> findReply(Long commentId) {
		List<Reply> replyList = replyRepository.findAllReplyByCommentId(commentId);
		List<ReplyResponse> repliesResponse = new ArrayList<ReplyResponse>();
		ListIterator<Reply> replies = replyList.listIterator();
		while(replies.hasNext()) {
			Reply reply = replies.next();
			User user = reply.getUser();
			String userReply = (reply.getReply() == null) ? new String()
					: new String(reply.getReply(), StandardCharsets.UTF_8);
			String currentProfile = (user.getPresentProfile() == null) ? new String()
					: new String(user.getPresentProfile(), StandardCharsets.UTF_8);
			ReplyResponse replyResponse = new ReplyResponse(reply.getReplyId(), user.getUserId(), user.getProfilePhoto(), user.getUserName(), currentProfile, userReply, reply.getReplyDate());
			repliesResponse.add(replyResponse);
		}
		return repliesResponse;
	}

}
