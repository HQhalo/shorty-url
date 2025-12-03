package com.shortly.shortly_url.domain.repository;

import com.shortly.shortly_url.domain.model.Url;

import java.util.Optional;

public interface UrlRepository {
    void save(Url url);
    Optional<Url> getByShortedUri(String shortedUri);
}
