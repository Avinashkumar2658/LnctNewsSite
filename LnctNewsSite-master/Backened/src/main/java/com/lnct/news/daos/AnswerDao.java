package com.lnct.news.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lnct.news.entities.Answer;

@Repository
public interface AnswerDao extends JpaRepository<Answer, Long> {

	List<Answer> getAllAnswerByQuestionId(Long questionId);

}
