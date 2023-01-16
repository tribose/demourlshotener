package com.urlshotener.demourlshotener.controller;

import com.urlshotener.demourlshotener.dto.RequestDTO;
import com.urlshotener.demourlshotener.dto.ResponseDTO;
import com.urlshotener.demourlshotener.service.IURLShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value = "/api/v1/urlshortener")
public class URLShortenerController {

    @Autowired
    private IURLShortenerService urlShortenerService;

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO> saveLongURL(@RequestBody RequestDTO requestDTO) {

        if (!StringUtils.hasText(requestDTO.getLongUrl())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        ResponseDTO response = urlShortenerService.saveLongURL(requestDTO);

        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/retrieve", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getLongUrl(@RequestParam("shortUrl") String shortUrl) {

        return ResponseEntity.ok(urlShortenerService.getLongUrl(shortUrl));
    }
}
