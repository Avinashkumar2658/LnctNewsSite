package com.lnct.news.services;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lnct.news.daos.HomeDao;
import com.lnct.news.entities.News;
import com.lnct.news.response.NewsResponse;

@Service
public class HomeService {

	@Autowired
	HomeDao homeRepositories;
	public List<NewsResponse> findAllNewsByCategoryName(Long categoryId) {
		List<News> retrievedAllImage = homeRepositories.findAllNewsByCategoryId(categoryId);
		List<NewsResponse> myListNews = new ArrayList<NewsResponse>();
		ListIterator<News> retrievedImages = retrievedAllImage.listIterator();
		while (retrievedImages.hasNext()) {
			News retrievedImage = retrievedImages.next();
			String user_role = "";
			int user_mode = retrievedImage.getUser().getUserMode();
			if (user_mode == 1)
				user_role = "admin";
			else if (user_mode == 0)
				user_role = "alumni";
			else if (user_mode == 2)
				user_role = "student";
			else
				user_role = "non-alumni";
			NewsResponse news = new NewsResponse(retrievedImage.getNewsId(), retrievedImage.getNewsHeading(),
					retrievedImage.getDetail(), retrievedImage.getStartDate(), retrievedImage.getEndDate(),
					retrievedImage.getCategoryId(), retrievedImage.getUser().getUserId(),
					retrievedImage.getUser().getUserName(), retrievedImage.getUser().getProfilePhoto(), user_role,
					retrievedImage.getCreateDate(), retrievedImage.getUrl(), retrievedImage.getPhoto());
			myListNews.add(news);
		}

		return myListNews;
	}
}
