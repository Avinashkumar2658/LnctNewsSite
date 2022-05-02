package com.lnct.news.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lnct.news.entities.Comment;

@Repository
public interface CommentDao extends JpaRepository<Comment, Long> {

	List<Comment> findAllCommentByAnswerId(Long answerId);
	List<Comment> findAllCommentByLargeNewsId(Long largeNewsId);

}
