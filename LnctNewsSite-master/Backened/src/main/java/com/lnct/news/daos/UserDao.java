package com.lnct.news.daos;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lnct.news.entities.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
	
	Optional<User> findByUserName(String userName);
	Optional<User> findByEnrollmentNo(String enrollmentNo);
	User findByUserId(Long userId);
	User findByEmailIdIgnoreCase(String emailId);
	
	@Query("select u from  User u where u.userMode = 0 ORDER BY u.userName ASC") 
	List<User> findAllUser();
	
	@Query("select u.userId, u.enrollmentNo, u.emailId from  User u where u.enabled = 0 ORDER BY u.userId") 
	List<Object[]> findAllBlockUser();
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("Update User u SET u.userName=:newUserName, u.someThingAboutYourSelf=:newSomeThingAboutYourSelf, u.presentProfile=:newPresentProfile, u.inspirationWord=:newInspirationWord, u.profilePhoto=:newProfilePhoto WHERE u.userId=:id")
    public void updateProfile(@Param("newUserName") String userName, @Param("newSomeThingAboutYourSelf") byte[] someThingAboutYourSelf, @Param("newPresentProfile") byte[] presentProfile, @Param("newInspirationWord") byte[] inspirationWord, @Param("newProfilePhoto") byte[] profilePhoto, @Param("id") Long id);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("Update User u SET u.password=:newPassword WHERE u.userId=:id")
    public void updatePassword(@Param("id") Long id, @Param("newPassword") String password);
	
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("Update User u SET u.enabled=:blockUser WHERE u.userId=:id")
    public void blockUser(@Param("id") Long id, @Param("blockUser") boolean enabled);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("Update User u SET u.enabled=:unblockUser WHERE u.userId=:id")
    public void unBlockUser(@Param("id") Long id, @Param("unblockUser") boolean enabled);
	
	
	String value = "select news_id, category_id, heading, detail, create_date from lnctnewsportal.news  where  user_id = ?1  and create_date between ?2  and ?3\r\n"
			+ "UNION\r\n"
			+ "	select news_id, category_id, heading, detail, create_date from lnctnewsportal.large_news  where  user_id = ?1 and create_date between ?2  and ?3\r\n"
			+ "			ORDER BY \r\n"
			+ "			create_date Desc ;";
	@Query( value = value , nativeQuery = true)
	List<Object[]> findAllUpdateByUserIdAndStartDateBetween(Long userId, Date startDate, Date endDate);

}