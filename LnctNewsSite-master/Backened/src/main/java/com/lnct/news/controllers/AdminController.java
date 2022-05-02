package com.lnct.news.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lnct.news.entities.Admin;
import com.lnct.news.response.ResponseMessage;
import com.lnct.news.services.AdminService;
import com.lnct.news.services.UserService;

@RestController
@CrossOrigin("http://lnctnewssite.s3-website.us-east-2.amazonaws.com")
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	@Autowired
	UserService userService;
	
	@PostMapping("/saveAdmin")
	public String saveAdmin(@RequestBody Admin admin) {
		System.out.println(admin);
		adminService.saveAdmin(admin);
		return "Save Admin Detail";
	}
	@GetMapping("findAdmin/{adminRegisteredId}")
	public String findAdmin(@PathVariable String adminRegisteredId) {
		
		String str = "";
		Optional<Admin> admin = adminService.findAdminByAdminRegisteredId(adminRegisteredId);
		if(admin.isPresent()) {
			str = admin.get().getAdminRegisteredId();
		}
		return str;
	}
	
	@GetMapping("/block_user_list")
	public List<Object[]> findBlockUser() {
		return userService.findAllBlockUser();
	}
	
	@PutMapping("/block_user")
	public ResponseEntity<ResponseMessage> blockUser(@RequestBody Long userId) {
		String message = "";
		try {
			userService.blockUser(userId);
			message = "user blocked successfully";
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		}
		catch(Exception e) {
			message = "user not blocked";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}
	}
	
	@PutMapping("/unblock_user")
	public ResponseEntity<ResponseMessage> unBlockUser(@RequestBody Long userId) {
		String message = "";
		try {
			userService.unBlockUser(userId);
			message = "user blocked successfully";
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		}
		catch(Exception e) {
			message = "user not blocked";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}
	}

}
