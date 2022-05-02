package com.lnct.news.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lnct.news.daos.ConfirmationTokenRepository;
import com.lnct.news.dto.UserDto;
import com.lnct.news.dto.UserRegistrationDto;
import com.lnct.news.entities.Admin;
import com.lnct.news.entities.ConfirmationToken;
import com.lnct.news.entities.User;
import com.lnct.news.response.ResponseMessage;
import com.lnct.news.response.UserResponse;
import com.lnct.news.services.AdminService;
import com.lnct.news.services.EmailSenderService;
import com.lnct.news.services.UserService;

@RestController
@CrossOrigin("http://lnctnewssite.s3-website.us-east-2.amazonaws.com")
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	ConfirmationTokenRepository confirmationTokenRepository;

	@Autowired
	EmailSenderService emailSenderService;

	@Autowired
	AdminService adminService;

	@PostMapping("/createUser")
	public ResponseEntity<ResponseMessage> createUser(@RequestBody UserRegistrationDto userRegister) {
		String message = "";
		try {
			User user = userRegister.getUser();
			User existingUser = userService.findByEmailIdIgnoreCase(userRegister.getEmailId());
			if (existingUser != null) {
				message = "this id is already exists";
				return ResponseEntity.status(HttpStatus.CONFLICT).body(new ResponseMessage(message));
			} else if (user.isAdmin()) {
				Optional<Admin> admin = adminService.findAdminByAdminRegisteredId(user.getEnrollmentNo());
				if (admin.isPresent()) {
					userService.saveUser(user);
					message = "A verification email has been sent to: " + user.getEmailId();
					return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));

				} else {
					message = "not registered";
					return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseMessage(message));
				}
			}
			userService.saveUser(user);
			message = "A verification email has been sent to: " + user.getEmailId();
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		} catch (Exception e) {
			message = "Could not upload the file: ";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}
	}

	@PostMapping("/forgot-password")
	public ResponseEntity<ResponseMessage> forgotUserPassword(@RequestBody String emailId) {
		String message = "";
		User existingUser = userService.findByEmailIdIgnoreCase(emailId);
		if (existingUser != null) {
			ConfirmationToken confirmationToken = new ConfirmationToken(existingUser.getUserId());
			confirmationTokenRepository.updateToken(confirmationToken.getUserId(),
					confirmationToken.getConfirmationToken(), confirmationToken.getCreatedDate());
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo(existingUser.getEmailId());
			mailMessage.setSubject("Complete Password Reset!");
			mailMessage.setFrom("nairobley@gmail.com");
			mailMessage.setText("To complete the password reset process, please click here: "
					+ "http://lnctnewssite.s3-website.us-east-2.amazonaws.com/#/reset-password/" + existingUser.getEnrollmentNo() + "/"
					+ confirmationToken.getConfirmationToken() + "/" + existingUser.getUserId());
			mailMessage.setText("Link is valid only for 48 hour");
			emailSenderService.sendEmail(mailMessage);
			message = "Request to reset password received. Check your inbox for the reset link.";
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseMessage(message));

		} else {
			message = "This email does not exist!";
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(new ResponseMessage(message));
		}
	}

	@PutMapping(value = "/reset-password/{enrollmentNo}")
	public ResponseEntity<ResponseMessage> resetUserPassword(@PathVariable("enrollmentNo") String enrollmentNo,
			@RequestBody String password) {
		String message = "";
		Optional<User> user = userService.findByEnrollmentNo(enrollmentNo);
		if (user.isPresent()) {
			User user1 = user.get();
			userService.updatePassword(user1.getUserId(), password);
			message = "Password successfully reset. You can now log in with the new credentials.";
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseMessage(message));
		} else {
			message = "The link is invalid or broken!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}
	}

	@GetMapping("/user/{id}")
	public UserResponse findByUserId(@PathVariable("id") Long userId) {
		return userService.findUserById(userId);
	}

	@PutMapping("/user")
	public void updateUser(@ModelAttribute UserDto userDto,
			@RequestPart(value = "profilePhoto", required = false) MultipartFile profilePhoto)
			throws IOException, InterruptedException {
		userService.updateUser(userDto, profilePhoto);
	}

	@GetMapping("/alumni_profile")
	public List<UserResponse> findAllAlumni() {
		return userService.findAllAlumni();
	}

	@GetMapping("/user_post_update/{userId}/{from}/to/{to}")
	public List<Object[]> findUserPostUpdate(@PathVariable Long userId,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date from,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date to) {
		return userService.findUserUpdatePostBetweenDate(userId, from, to);
	}

	@GetMapping("/user_credential/{userId}/{pattern_url}")
	public int findUserconfirmation(@PathVariable("userId") String userId, @PathVariable("pattern_url") String pattern_url) throws ParseException {
		Long id = Long.parseLong(userId);
		return userService.findUserconfirmation(id, pattern_url);
	}

}
