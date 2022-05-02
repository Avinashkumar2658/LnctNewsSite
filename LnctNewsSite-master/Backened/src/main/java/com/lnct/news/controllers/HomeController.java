package com.lnct.news.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.lnct.news.response.NewsResponse;
import com.lnct.news.services.HomeService;

@RestController
@CrossOrigin("http://lnctnewssite.s3-website.us-east-2.amazonaws.com")
public class HomeController {

	@Autowired
	HomeService homeService;
	@GetMapping("/home/{categoryId}")
	public List<NewsResponse> getAllUpdate(@PathVariable Long categoryId) throws IOException {
		
		return homeService.findAllNewsByCategoryName(categoryId);
	
	}
}
