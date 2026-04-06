package org.example.urlshortener.controller;

import org.example.urlshortener.dto.Urlrequest;
import org.example.urlshortener.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*") // optional but safe for frontend
public class UrlController {

    @Autowired
    private UrlService service;

    @PostMapping("/shorten")
    public String shorten(@RequestBody Urlrequest request) {
        String code = service.shortenUrl(request.getUrl());
        return "http://localhost:8080/r/" + code;
    }

    @GetMapping("/r/{code}")
    public ResponseEntity<?> redirect(@PathVariable String code) {

        try {
            String originalUrl = service.getOriginalUrl(code);

            return ResponseEntity.status(HttpStatus.FOUND)
                    .header("Location", originalUrl)
                    .build();

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Short URL not found");
        }
    }
}