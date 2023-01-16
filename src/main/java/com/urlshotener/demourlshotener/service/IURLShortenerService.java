package com.urlshotener.demourlshotener.service;

import com.urlshotener.demourlshotener.dto.RequestDTO;
import com.urlshotener.demourlshotener.dto.ResponseDTO;

public interface IURLShortenerService {

    ResponseDTO saveLongURL(RequestDTO requestDTO);

    String getLongUrl(String shortUrl);
}
