package com.lnct.news.services;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lnct.news.daos.CommentDao;
import com.lnct.news.entities.Comment;
import com.lnct.news.entities.User;
import com.lnct.news.response.CommentResponse;

@Service
public class CommentService {
	
	@Autowired
	CommentDao commentDao;
	
	public Comment createComment(Comment comment) {
		return commentDao.save(comment);
	}
	
	public List<CommentResponse> findComment(Long answerId) {
		List<Comment> commentList = commentDao.findAllCommentByAnswerId(answerId);
		List<CommentResponse> commentsResponse = new ArrayList<CommentResponse>();
		ListIterator<Comment> comments = commentList.listIterator();
		while(comments.hasNext()) {
			Comment comment = comments.next();
			User user = comment.getUser();
			String userComment = (comment.getComment() == null) ? new String()
					: new String(comment.getComment(), StandardCharsets.UTF_8);
			String currentProfile = (user.getPresentProfile() == null) ? new String()
					: new String(user.getPresentProfile(), StandardCharsets.UTF_8);
			CommentResponse commentResponse = new CommentResponse(comment.getCommentId(), user.getUserId(), user.getProfilePhoto(), user.getUserName(), currentProfile, userComment, comment.getCommentDate());
			commentsResponse.add(commentResponse);
		}
		return commentsResponse;
	}
	
	public List<CommentResponse> findLargeNewsComment(Long largeNewsId) {
		List<Comment> commentList = commentDao.findAllCommentByLargeNewsId(largeNewsId);
		List<CommentResponse> commentsResponse = new ArrayList<CommentResponse>();
		ListIterator<Comment> comments = commentList.listIterator();
		while(comments.hasNext()) {
			Comment comment = comments.next();
			User user = comment.getUser();
			String userComment = (comment.getComment() == null) ? new String()
					: new String(comment.getComment(), StandardCharsets.UTF_8);
			String currentProfile = (user.getPresentProfile() == null) ? new String()
					: new String(user.getPresentProfile(), StandardCharsets.UTF_8);
			CommentResponse commentResponse = new CommentResponse(comment.getCommentId(), user.getUserId(), user.getProfilePhoto(), user.getUserName(), currentProfile, userComment, comment.getCommentDate());
			commentsResponse.add(commentResponse);
		}
		return commentsResponse;
	}
}
