package com.lnct.news.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lnct.news.entities.Reply;

@Repository
public interface ReplyDao extends JpaRepository<Reply, Long> {

	List<Reply> findAllReplyByCommentId(Long commentId);

}
