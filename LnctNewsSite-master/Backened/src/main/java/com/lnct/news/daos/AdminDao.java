package com.lnct.news.daos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lnct.news.entities.Admin;

@Repository
public interface AdminDao extends JpaRepository<Admin, Long>{

	Optional<Admin> findAdminByAdminRegisteredId(String adminRegisteredId);

}
