package com.lnct.news.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.lnct.news.entities.LargeNews;

@EnableJpaRepositories
public interface ExamDao extends JpaRepository<LargeNews, Long> {
	@Query("select exam from LargeNews exam where exam.semester = ?1 and exam.categoryId = ?2") 
	List<LargeNews>  findBySemesterAndCategoryId(int semester, Long categoryId);

	Optional<LargeNews> findByLargeNewsId(Long largeNewsId);
}
