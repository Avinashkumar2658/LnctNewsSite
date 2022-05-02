package com.lnct.news.controllers;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lnct.news.entities.LargeNews;
import com.lnct.news.response.ResponseFile;
import com.lnct.news.services.ClassNotesService;

@CrossOrigin("http://lnctnewssite.s3-website.us-east-2.amazonaws.com")
@RestController
public class ClassNotesController {
	@Autowired
	ClassNotesService classNotesService;

	@GetMapping("/class_notes/{semester}")
	public ResponseEntity<List<ResponseFile>> getListFiles(@PathVariable int semester) {
		List<ResponseFile> files = classNotesService.findClassNotes(semester).map(dbFile -> {
			String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/class_notes/semester/")
					.path(String.valueOf(dbFile.getLargeNewsId())).toUriString();

			return new ResponseFile(dbFile.getLargeNewsId(), dbFile.getLargeNewsHeading(), dbFile.getDetail(),
					dbFile.getFile().getName(), dbFile.getUser().getUserId(), dbFile.getUser().getUserName(), dbFile.getUser().getProfilePhoto(),
					(dbFile.getUser().getPresentProfile() == null) ? new String()
							: new String(dbFile.getUser().getPresentProfile(), StandardCharsets.UTF_8),
					dbFile.getCreateDate(), dbFile.getUrl(), fileDownloadUri, dbFile.getFile().getType(),
					dbFile.getFile().getData().length);
		}).collect(Collectors.toList());

		return ResponseEntity.status(HttpStatus.OK).body(files);
	}

	@GetMapping("/class_notes/semester/{largeNewsId}")
	public ResponseEntity<byte[]> getFile(@PathVariable Long largeNewsId) {
		LargeNews fileDB = classNotesService.getFile(largeNewsId);

		return ResponseEntity.ok().contentType(MediaType.parseMediaType(fileDB.getFile().getType()))

				.header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + fileDB.getFile().getName() + "\"")

				.body(fileDB.getFile().getData());
	}

}
