package com.lnct.news.daos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lnct.news.entities.Category;
@Repository
public interface CategoriesDao extends JpaRepository<Category, Long> {

	Optional<Category> findByCategoryName(String categoryName);
	
	Category findByCategoryId(long id);
	

}
