package com.lnct.news.services;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lnct.news.daos.TnpDao;
import com.lnct.news.entities.LargeNews;
@Service
public class TnpService {
	
	@Autowired
	TnpDao tnpDao;
	
	public Stream<LargeNews> findTnpUpdate(int semester) {
		Long categoryId = 9l;
		List<LargeNews> tnpData = tnpDao.findBySemesterAndCategoryId(semester, categoryId);
		return tnpData.stream();
	}
	
	public LargeNews getFile(Long largeNewsId) {
	    return tnpDao.findByLargeNewsId(largeNewsId).get();
	  }
}
