package com.lnct.news.daos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lnct.news.entities.LargeNews;

@Repository
public interface LargeNewsDao extends JpaRepository<LargeNews, Long> {


	LargeNews  findLargeNewsByLargeNewsId(Long largeNewsId);;

	Optional<LargeNews> findByLargeNewsId(Long largeNewsId);
}
