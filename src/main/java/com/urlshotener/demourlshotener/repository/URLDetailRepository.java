package com.urlshotener.demourlshotener.repository;

import com.urlshotener.demourlshotener.entity.URLDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface URLDetailRepository extends JpaRepository<URLDetail, Integer> {

    String findByShortUrl(String shortUrl);
}
