package com.lnct.news.services;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lnct.news.daos.ConfirmationTokenRepository;
import com.lnct.news.daos.UserDao;
import com.lnct.news.dto.UserDto;
import com.lnct.news.entities.ConfirmationToken;
import com.lnct.news.entities.User;
import com.lnct.news.response.UserResponse;

@Service
public class UserService {
	@Autowired
	UserDao userRepository;
	@Autowired
	ConfirmationTokenRepository confirmationTokenRepository;

	@Autowired
	EmailSenderService emailSenderService;
	
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	public void saveUser(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);
		User user1 = findByEmailIdIgnoreCase(user.getEmailId());
		ConfirmationToken confirmationToken = new ConfirmationToken(user1.getUserId());
		confirmationTokenRepository.save(confirmationToken);
//		SimpleMailMessage mailMessage = new SimpleMailMessage();
//		mailMessage.setTo(user.getEmailId());
//		mailMessage.setSubject("Registration Successful");
//		mailMessage.setFrom("nairobley@gmail.com");
//		mailMessage.setText("You are successfully registered with LNCTnewsSITE now you can Post comment and make profile");
//		mailMessage.setText("if not then forward me");
//		emailSenderService.sendEmail(mailMessage);
	}

	public void updateUser(UserDto userDto, MultipartFile profilePhoto) throws IOException, InterruptedException {
		User user = userDto.getUserDetail();
		User fixedUserData = userRepository.findByEmailIdIgnoreCase(user.getEmailId());
		user.setProfilePhoto(profilePhoto.getBytes());
		userRepository.updateProfile(user.getUserName(), user.getSomeThingAboutYourSelf(), user.getPresentProfile(), user.getInspirationWord(), user.getProfilePhoto(), fixedUserData.getUserId());
	}

	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);
	}

	public UserResponse findUserById(Long userId) {
		User user = userRepository.findByUserId(userId);
		String inspirationWord = (user.getInspirationWord() == null) ? new String()
				: new String(user.getInspirationWord(), StandardCharsets.UTF_8);
		String someThingAboutYourSelf = (user.getSomeThingAboutYourSelf() == null) ? new String()
				: new String(user.getSomeThingAboutYourSelf(), StandardCharsets.UTF_8);
		String presentProfile = (user.getPresentProfile() == null) ? new String()
				: new String(user.getPresentProfile(), StandardCharsets.UTF_8);
		return new UserResponse(user.getUserId(), user.getUserName(), user.getEnrollmentNo(), user.getPassword(),
				user.getEmailId(), user.getUserMode(), user.isAdmin(), someThingAboutYourSelf, presentProfile,
				inspirationWord, user.getProfilePhoto());
	}

	public User findByUserId(Long userId) {
		return userRepository.findByUserId(userId);
	}

	public Optional<User> findByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}

	public Optional<User> findByEnrollmentNo(String enrollmentNo) {
		return userRepository.findByEnrollmentNo(enrollmentNo);
	}

	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	public List<UserResponse> findAllAlumni() {
		List<User> alumniList = userRepository.findAllUser();
		List<UserResponse> userAlumniResponseList = new ArrayList<UserResponse>();
		ListIterator<User> alumnis = alumniList.listIterator();
		while (alumnis.hasNext()) {
			User alumni = alumnis.next();
			String inspirationWord = (alumni.getInspirationWord() == null) ? new String()
					: new String(alumni.getInspirationWord(), StandardCharsets.UTF_8);
			String someThingAboutYourSelf = (alumni.getSomeThingAboutYourSelf() == null) ? new String()
					: new String(alumni.getSomeThingAboutYourSelf(), StandardCharsets.UTF_8);
			String presentProfile = (alumni.getPresentProfile() == null) ? new String()
					: new String(alumni.getPresentProfile(), StandardCharsets.UTF_8);

			userAlumniResponseList.add(new UserResponse(0l, alumni.getUserName(), "", "", alumni.getEmailId(), 0, true,
					someThingAboutYourSelf, presentProfile, inspirationWord, alumni.getProfilePhoto()));
		}
		return userAlumniResponseList;
	}

	public User findByEmailIdIgnoreCase(String emailId) {
		return userRepository.findByEmailIdIgnoreCase(emailId);
	}

	public void updatePassword(Long userId, String password) {
		
		userRepository.updatePassword(userId, encoder.encode(password));
	}

	public List<Object[]> findAllBlockUser() {
		List<Object[]> blockUserList = userRepository.findAllBlockUser();
		return blockUserList;
	}
	public void blockUser(Long userId) {
		userRepository.blockUser(userId, false);
	}
	public void unBlockUser(Long userId) {
		userRepository.unBlockUser(userId, true);
	}
	
	public List<Object[]> findUserUpdatePostBetweenDate(Long userId, Date startDate, Date endDate) {
		return userRepository.findAllUpdateByUserIdAndStartDateBetween(userId, startDate, endDate);
	}

	public int findUserconfirmation(Long userId, String pattern_url) throws ParseException {
		int cond  = 0;
		ConfirmationToken confirmationToken = confirmationTokenRepository.findByUserId(userId);
		if(!(pattern_url.equals(confirmationToken.getConfirmationToken())))
			return cond;
		String  date[]  = String.valueOf(confirmationToken.getCreatedDate()).split("\\.");
		Date date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date[0].trim());
		 long MILLIS_PER_Two_DAY = 2 * 24 * 60 * 60 * 1000L;
	    Long l = date1.getTime();
	    Long now = new Date().getTime();
	    if(now - l<= MILLIS_PER_Two_DAY) 
			cond =  1;
	    return cond;
	}
}
