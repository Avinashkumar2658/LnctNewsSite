package com.lnct.news.services;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lnct.news.daos.ClassNotesDao;
import com.lnct.news.entities.LargeNews;
@Service
public class ClassNotesService {
	
	@Autowired
	ClassNotesDao classNotesDao;

	public Stream<LargeNews> findClassNotes(int semester) {
		Long categoryId = 7l;
		List<LargeNews> classNotes = classNotesDao.findBySemesterAndCategoryId(semester, categoryId);
		return classNotes.stream();
	}
	
	public LargeNews getFile(Long largeNewsId) {
	    return classNotesDao.findByLargeNewsId(largeNewsId).get();
	  }
}
