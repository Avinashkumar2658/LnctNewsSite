package com.lnct.news.services;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lnct.news.daos.ExamDao;
import com.lnct.news.entities.LargeNews;
@Service
public class ExamService {
	@Autowired
	ExamDao examDao;
	
	public Stream<LargeNews> findExamUpdate(int semester) {
		Long categoryId = 8l;
		List<LargeNews> examData = examDao.findBySemesterAndCategoryId(semester, categoryId);
		return examData.stream();
	}
	
	public LargeNews getFile(Long largeNewsId) {
	    return examDao.findByLargeNewsId(largeNewsId).get();
	  }
}
