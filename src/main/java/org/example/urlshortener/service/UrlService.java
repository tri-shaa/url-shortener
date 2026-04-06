

package org.example.urlshortener.service;

import org.example.urlshortener.model.Url;
import org.example.urlshortener.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UrlService {

    @Autowired
    private UrlRepository repository;

    public String shortenUrl(String originalUrl) {
        String shortCode = UUID.randomUUID().toString().substring(0, 6);

        Url url = new Url();
        url.setOriginalUrl(originalUrl);
        url.setShortCode(shortCode);

        repository.save(url);

        return shortCode;
    }

    public String getOriginalUrl(String shortCode) {
        return repository.findByShortCode(shortCode)
                .map(Url::getOriginalUrl)
                .orElseThrow(() -> new RuntimeException("URL not found"));
    }
}
