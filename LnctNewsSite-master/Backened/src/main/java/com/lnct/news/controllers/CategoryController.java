package com.lnct.news.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lnct.news.entities.Category;
import com.lnct.news.services.CategoryService;

@RestController
@CrossOrigin("http://lnctnewssite.s3-website.us-east-2.amazonaws.com")
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@PostMapping("/createCategory")
	public Category createCategory(@RequestBody Category category) {
		category = categoryService.saveCategories(category);
		return category;
	}

	@PutMapping("/updateCategory")
	public void updateCategory(Category category) {
		categoryService.saveCategories(category);
	}

	@DeleteMapping("/deleteCategory")
	public void deleteCategory(Long categoryId) {
		categoryService.deleteCategories(categoryId);
	}

	@GetMapping("/categories")
	public List<Category> findAllCategory() {
		return categoryService.findAllCategories();
	}
}
