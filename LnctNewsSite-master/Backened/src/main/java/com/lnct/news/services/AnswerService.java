package com.lnct.news.services;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lnct.news.daos.AnswerDao;
import com.lnct.news.entities.Answer;
import com.lnct.news.entities.User;
import com.lnct.news.response.AnswerResponse;
import com.lnct.news.response.UserResponse;

@Service
public class AnswerService {

	@Autowired
	AnswerDao answerRepository;
	
	public Answer createAnswer(Answer answer) {
		return answerRepository.save(answer);
	}
	
	public void deleteAnswer(Long answerId) {
		answerRepository.deleteById(answerId);
	}
	
	
	public List<AnswerResponse> getAllAnswerByQuestionId(Long questionId) {
		List<Answer> answerList = answerRepository.getAllAnswerByQuestionId(questionId);
		List<AnswerResponse> answerResponseDtoList = new ArrayList<AnswerResponse>();
		ListIterator<Answer> answers = answerList.listIterator();
		while(answers.hasNext()) {
			Answer ans = answers.next();
			String str = (ans.getAnswer() == null) ? new String()
					: new String(ans.getAnswer(), StandardCharsets.UTF_8);
			User user = ans.getUser();
			String currentProfile = (user.getPresentProfile() == null) ? new String()
					: new String(user.getPresentProfile(), StandardCharsets.UTF_8);
			String inspiration = (user.getInspirationWord() == null) ? new String()
					: new String(user.getInspirationWord(), StandardCharsets.UTF_8);
			String someThingAboutYourSelf = (user.getSomeThingAboutYourSelf() == null) ? new String()
					: new String(user.getSomeThingAboutYourSelf(), StandardCharsets.UTF_8);
			UserResponse userResponse = new UserResponse(user.getUserId(), user.getUserName(), user.getEnrollmentNo(), user.getPassword(), user.getEmailId(),
					user.getUserMode(), user.isAdmin(), someThingAboutYourSelf, currentProfile,
					inspiration, user.getProfilePhoto());
			AnswerResponse answerDto = new AnswerResponse(ans.getAnswerId(), str, ans.getCreateDate(), userResponse, ans.getQuestionId());
			answerResponseDtoList.add(answerDto);
		}
		return answerResponseDtoList;
		
	}
}
