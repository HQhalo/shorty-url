package com.shortly.shortly_url.infra.persistence.repository;

import com.shortly.shortly_url.infra.persistence.entity.UrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaUrlRepository extends JpaRepository<UrlEntity, Long> {
    Optional<UrlEntity> findByShortedUri(String shortedUri);
}
