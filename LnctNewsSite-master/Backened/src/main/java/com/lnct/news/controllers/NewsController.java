package com.lnct.news.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lnct.news.dto.NewsDto;
import com.lnct.news.entities.News;
import com.lnct.news.entities.User;
import com.lnct.news.response.NewsResponse;
import com.lnct.news.response.ResponseMessage;
import com.lnct.news.services.CategoryService;
import com.lnct.news.services.NewsService;
import com.lnct.news.services.UserService;

@CrossOrigin("http://lnctnewssite.s3-website.us-east-2.amazonaws.com")
@RestController
public class NewsController {

	@Autowired
	NewsService newsService;
	@Autowired
	CategoryService categoryService;

	@Autowired
	UserService userService;

	@PostMapping("/createNews")
	@ResponseBody
	public ResponseEntity<ResponseMessage> createNews(@ModelAttribute NewsDto model,
			@RequestPart("file") MultipartFile file) throws IOException, ParseException {
			String message = "";
		try {
			News n = new News();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			n.setNewsId(Long.parseLong(String.valueOf(model.getNewsId().replace("\"", ""))));
			n.setNewsHeading(model.getNewsHeading().replace("\"", ""));
			n.setDetail(model.getDetail().replace("\"", ""));
			String dateWOQ = model.getStartDate().replace("\"", "");
			Date date = sdf.parse(dateWOQ);
			String eDateWOQ = model.getEndDate().replace("\"", "");
			n.setStartDate(date);
			Date edate = sdf.parse(eDateWOQ);
			n.setEndDate(edate);
			long id = Long.parseLong(String.valueOf(model.getCategoryId().replace("\"", "")));
			n.setCategoryId(id);
			User user = userService.findByUserId(Long.parseLong(String.valueOf(model.getUserId().replace("\"", ""))));
			n.setUser(user);
			n.setUrl(String.valueOf(model.getUrl().replace("\"", "")));
			n.setPhoto(file.getBytes());
			n.setCreateDate(new Date());
			newsService.createNews(n);
			message = "Uploaded the file successfully: " + file.getOriginalFilename();
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		} catch (Exception e) {
			message = "Could not upload the file: " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}
	}

	@PutMapping("/updateNews")
	public void updateNews(News news) {
		newsService.createNews(news);
	}

	@DeleteMapping("/deleteNews/{newsId}")
	public void DeleteNews(@PathVariable("newsId") Long newsId) {
		newsService.deleteNews(newsId);
	}

	@GetMapping("/getall")
	public List<NewsResponse> getAllNews() throws IOException {

		return newsService.findAllNews();
	}
	@GetMapping("/news/{newsId}")
	public NewsResponse getNewsByNewsId(@PathVariable("newsId") Long newsId) throws IOException {
		return newsService.findNewsByNewsId(newsId);
	}
}
