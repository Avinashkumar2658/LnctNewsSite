package com.lnct.news.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lnct.news.daos.AdminDao;
import com.lnct.news.entities.Admin;

@Service
public class AdminService {

	@Autowired
	AdminDao adminDao;
	
	public void saveAdmin(Admin admin) {
		adminDao.save(admin);
	}
	
	public Optional<Admin> findAdminByAdminRegisteredId(String adminRegisteredId) {
		return adminDao.findAdminByAdminRegisteredId(adminRegisteredId);
	}
}
