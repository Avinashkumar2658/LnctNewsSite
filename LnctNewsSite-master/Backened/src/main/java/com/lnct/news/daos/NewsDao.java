package com.lnct.news.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lnct.news.entities.News;

@Repository
public interface NewsDao extends JpaRepository<News, Long> {

	List<News> findAllNewsByUser(Long userId);

	News findNewsByNewsId(Long newsId);

	@Query("select news from  News news where  news.categoryId = 2 and DATE(news.endDate) >= DATE(NOW()) ORDER BY news.endDate ASC") 
	List<News> findAllUppcommingEventInCollege();

	

}
