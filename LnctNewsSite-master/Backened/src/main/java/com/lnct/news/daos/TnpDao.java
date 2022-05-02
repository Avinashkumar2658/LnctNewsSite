package com.lnct.news.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lnct.news.entities.LargeNews;

public interface TnpDao extends JpaRepository<LargeNews, Long> {
	
	@Query("select tnp_update from LargeNews tnp_update where tnp_update.semester = ?1 and tnp_update.categoryId = ?2") 
	List<LargeNews>  findBySemesterAndCategoryId(int semester, Long categoryId);

	Optional<LargeNews> findByLargeNewsId(Long largeNewsId);
	
	Optional<LargeNews> findByCategoryId(Long categoryId);
}
