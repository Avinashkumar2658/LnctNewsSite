package com.lnct.news.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lnct.news.entities.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question, Long> {



}
