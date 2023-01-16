package com.urlshotener.demourlshotener.service;

import com.urlshotener.demourlshotener.dto.RequestDTO;
import com.urlshotener.demourlshotener.dto.ResponseDTO;
import com.urlshotener.demourlshotener.entity.URLDetail;
import com.urlshotener.demourlshotener.repository.URLDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class URLShortenerServiceImpl implements IURLShortenerService {

    @Autowired
    private URLDetailRepository urlDetailRepository;

    @Override
    public ResponseDTO saveLongURL(RequestDTO requestDTO) {

        URLDetail urlDetail = new URLDetail(buildShortURL(), requestDTO.getLongUrl());

        URLDetail urlDetailEntity = urlDetailRepository.save(urlDetail);

        ResponseDTO responseDTO = new ResponseDTO();

        responseDTO.setShortURL(urlDetailEntity.getShortUrl());

        return responseDTO;

    }

    @Override
    public String getLongUrl(String shortUrl) {
        return urlDetailRepository.findByShortUrl(shortUrl);
    }

    private String buildShortURL() {
        UUID uuid = new UUID(100000, 999999);

        return "http://shorturl" + uuid + ".com";
    }

    /*public static void main(String[] args) {
        UUID uuid = new UUID(100000, 999999);
        System.out.println(uuid);
    }*/

}
