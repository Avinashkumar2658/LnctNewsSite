package com.lnct.news.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lnct.news.dto.LargeNewsDto;
import com.lnct.news.entities.FileDB;
import com.lnct.news.entities.LargeNews;
import com.lnct.news.entities.User;
import com.lnct.news.response.ResponseFile;
import com.lnct.news.response.ResponseMessage;
import com.lnct.news.services.LargeNewsService;
import com.lnct.news.services.UserService;

@CrossOrigin("http://lnctnewssite.s3-website.us-east-2.amazonaws.com")
@RestController
public class LargeNewsController {

	@Autowired
	LargeNewsService largeNewsService;

	@Autowired
	UserService userService;

	@PostMapping("/createLargeNews")
	@ResponseBody
	public ResponseEntity<ResponseMessage> createLargeNews(@ModelAttribute LargeNewsDto largeNewsDto,
			@RequestPart(value = "file", required = false) MultipartFile file) throws IOException, ParseException {
		String message = "";
		try {
			LargeNews largeNews = new LargeNews();
			largeNews.setLargeNewsId(Long.parseLong(String.valueOf(largeNewsDto.getLargeNewsId()).replace("\"", "")));
			largeNews.setLargeNewsHeading(String.valueOf(largeNewsDto.getLargeNewsHeading()).replace("\"", ""));
			largeNews.setDetail(String.valueOf(largeNewsDto.getDetail()).replace("\"", ""));
			largeNews.setYear(Integer.parseInt(String.valueOf(largeNewsDto.getYear()).replace("\"", "")));
			largeNews.setSemester(Integer.parseInt(String.valueOf(largeNewsDto.getSemester()).replace("\"", "")));
			User user = userService
					.findByUserId(Long.parseLong(String.valueOf(largeNewsDto.getUserId()).replace("\"", "")));
			largeNews.setUser(user);
			largeNews.setUrl(String.valueOf(largeNewsDto.getUrl()).replace("\"", ""));
			Long id = Long.parseLong(String.valueOf(largeNewsDto.getCategoryId()).replace("\"", ""));
			largeNews.setCategoryId(id);
			largeNews.setFile(new FileDB(file.getOriginalFilename(), file.getContentType(), file.getBytes()));
			largeNews.setCreateDate(new Date());
			largeNewsService.createLargeNews(largeNews);
			message = "Uploaded the file successfully ";
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		} catch (Exception e) {
			message = "Could not upload the file: " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));

		}

	}

	@GetMapping("/largeNewsFile/{largeNewsId}")
	public ResponseEntity<ResponseFile> getListFiles(@PathVariable Long largeNewsId) {
		LargeNews file = largeNewsService.findNewsUpdateByNewsId(largeNewsId);
		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/file/")
				.path(String.valueOf(file.getLargeNewsId())).toUriString();
		ResponseFile responseFile = new ResponseFile(file.getLargeNewsId(), file.getLargeNewsHeading(),
				file.getDetail(), file.getFile().getName(), file.getCreateDate() , file.getUrl(), fileDownloadUri,
				file.getFile().getType(), file.getFile().getData().length);
		return ResponseEntity.status(HttpStatus.OK).body(responseFile);
	}

	@GetMapping("/file/{largeNewsId}")
	public ResponseEntity<byte[]> getFile(@PathVariable Long largeNewsId) {
		LargeNews fileDB = largeNewsService.getFile(largeNewsId);
		return ResponseEntity.ok().contentType(MediaType.parseMediaType(fileDB.getFile().getType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + fileDB.getFile().getName() + "\"")
				.body(fileDB.getFile().getData());
	}
	
	@DeleteMapping("/deleteLargeNews/{newsId}")
	public void deleteNewsByNewsId(@PathVariable("newsId") Long newsId) {
		largeNewsService.deleteLargeNews(newsId);
	}

}
