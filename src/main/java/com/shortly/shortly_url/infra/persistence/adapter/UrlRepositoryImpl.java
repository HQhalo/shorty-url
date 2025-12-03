package com.shortly.shortly_url.infra.persistence.adapter;

import com.shortly.shortly_url.domain.model.Url;
import com.shortly.shortly_url.domain.repository.UrlRepository;
import com.shortly.shortly_url.infra.persistence.mapper.UrlMapper;
import com.shortly.shortly_url.infra.persistence.repository.JpaUrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UrlRepositoryImpl implements UrlRepository {
    private final JpaUrlRepository jpaUrlRepository;

    private final UrlMapper urlMapper;

    @Override
    public void save(Url url) {
        var urlEntity = urlMapper.toEntity(url);
        jpaUrlRepository.save(urlEntity);
    }

    @Override
    public Optional<Url> getByShortedUri(String shortedUri) {
        var urlEntity = jpaUrlRepository.findByShortedUri(shortedUri);
        return urlEntity.map(urlMapper::toModel);
    }
}
