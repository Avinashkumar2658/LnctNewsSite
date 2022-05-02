package com.lnct.news.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lnct.news.entities.LargeNews;

public interface ClassNotesDao extends JpaRepository<LargeNews, Long> {
	
	@Query("select class_notes from LargeNews class_notes where class_notes.semester = ?1 and class_notes.categoryId = ?2") 
	List<LargeNews>  findBySemesterAndCategoryId(int semester, Long categoryId);

	Optional<LargeNews> findByLargeNewsId(Long largeNewsId);
	Optional<LargeNews> findBySemester(int semester);
}
