package com.lnct.news.daos;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.lnct.news.entities.ConfirmationToken;

public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, String> {
	ConfirmationToken findByConfirmationToken(String confirmationToken);
	
	ConfirmationToken findByUserId(Long userId);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("Update ConfirmationToken u SET u.confirmationToken=:newconfirmationToken, u.createdDate=:newcreatedDate WHERE u.userId=:id")
    public void updateToken(@Param("id") Long id, @Param("newconfirmationToken") String confirmationToken, @Param("newcreatedDate") Date createdDate);
}
