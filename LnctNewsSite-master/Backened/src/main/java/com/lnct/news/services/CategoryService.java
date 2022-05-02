package com.lnct.news.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lnct.news.daos.CategoriesDao;
import com.lnct.news.entities.Category;
;

@Service
public class CategoryService {
	@Autowired
	CategoriesDao categoriesRepository;
	
	public Category saveCategories(Category category) {
		return categoriesRepository.save(category);
	}
	
	public void deleteCategories(Long categoriesId) {
		categoriesRepository.deleteById(categoriesId);
	}
	
	public void updateCategories(Category category) {
		categoriesRepository.save(category);
	}
	public Category findCategoryById(Long categoriesId) {
		return categoriesRepository.findByCategoryId(categoriesId);
	}

	public Optional<Category> findByCategoryName(String categoryName) {
		return categoriesRepository.findByCategoryName(categoryName);
	}

	public List<Category> findAllCategories() {
		return categoriesRepository.findAll();

	}

}
