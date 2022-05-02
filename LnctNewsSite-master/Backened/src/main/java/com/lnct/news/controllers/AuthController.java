package com.lnct.news.controllers;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lnct.news.entities.User;
import com.lnct.news.security.AuthenticationBean;
import com.lnct.news.services.UserService;

@CrossOrigin("http://lnctnewssite.s3-website.us-east-2.amazonaws.com")
@RestController
public class AuthController {

	@Autowired
	UserService userService;

	@GetMapping("/user/basicauth")
	public AuthenticationBean getAuthentionMesage(Principal principal) {
		Optional<User> optUser = userService.findByEnrollmentNo(principal.getName());
		User user = optUser.get();
		AuthenticationBean ab = new AuthenticationBean(user.getUserId(), user.isAdmin(), user.isEnabled());
		return ab;
	}

}
