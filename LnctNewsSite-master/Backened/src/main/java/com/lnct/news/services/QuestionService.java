package com.lnct.news.services;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lnct.news.daos.QuestionDao;
import com.lnct.news.dto.QuestionDto;
import com.lnct.news.entities.Question;

@Service
public class QuestionService {
	@Autowired
	QuestionDao questionDao;

	public Question createQuestion(QuestionDto questionDto) {
		Question question = new Question();
		question.setQuestionId(questionDto.getQuestionId());
		question.setUserId(questionDto.getUserId());
		question.setQuestion(questionDto.getQuestion().getBytes());
		return questionDao.save(question);
	}

	public Question updateQuestion(Question question) {
		return questionDao.save(question);
	}

	public void deleteQuestion(Long questionId) {
		questionDao.deleteById(questionId);
	}

	public Optional<Question> findQuestionById(Long questionId) {
		return questionDao.findById(questionId);
	}

	public List<QuestionDto> findAllQuestion() {
		List<Question> questions = questionDao.findAll();
		List<QuestionDto> questionDtos = new ArrayList<QuestionDto>();
		Question question = new Question();
		QuestionDto questionDto = null;
		Iterator<Question> it = questions.iterator();
		while (it.hasNext()) {
			question = it.next();
			questionDto = new QuestionDto();
			questionDto.setQuestionId(question.getQuestionId());
			questionDto.setUserId(question.getUserId());
			String str = new String(question.getQuestion(), StandardCharsets.UTF_8);
			questionDto.setQuestion(str);
			questionDtos.add(questionDto);
		}
		return questionDtos;
	}
}
