package com.lnct.news.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lnct.news.daos.LargeNewsDao;
import com.lnct.news.entities.LargeNews;

@Service
public class LargeNewsService {
	@Autowired
	LargeNewsDao largeNewsDao;
	@Autowired
	CategoryService categoryService;

	public LargeNews createLargeNews(LargeNews largeNews) {
		return largeNewsDao.save(largeNews);
	}

	public LargeNews updateLargeNews(LargeNews largeNews) {
		return largeNewsDao.save(largeNews);
	}

	public void deleteLargeNews(long largeNewsId) {
		largeNewsDao.deleteById(largeNewsId);
	}

	public Optional<LargeNews> findLargeNewsById(Long largeNewsId) {
		return largeNewsDao.findById(largeNewsId);
	}

	public List<LargeNews> findAllLargeNews() {
		return largeNewsDao.findAll();
	}

	public LargeNews findNewsUpdateByNewsId(long largeNewsId) {
		LargeNews data = largeNewsDao.findLargeNewsByLargeNewsId(largeNewsId);
		return data;
	}

	public LargeNews getFile(Long largeNewsId) {
		return largeNewsDao.findByLargeNewsId(largeNewsId).get();
	}
	
	public void deleteNewsByNewsId(Long newsId) {
		largeNewsDao.deleteById(newsId);
	}

}
