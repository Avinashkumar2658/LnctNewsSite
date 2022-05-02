package com.lnct.news.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lnct.news.entities.News;
@Repository																															
public interface HomeDao extends JpaRepository<News, Long> {
	@Query("select news from News news where news.categoryId = ?1")
	List<News> findAllNewsByCategoryId(Long categoryId);
}
