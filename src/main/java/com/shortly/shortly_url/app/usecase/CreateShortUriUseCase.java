package com.shortly.shortly_url.app.usecase;

import com.shortly.shortly_url.domain.model.Url;
import com.shortly.shortly_url.domain.repository.UrlRepository;
import com.shortly.shortly_url.domain.service.ShortCodeGeneratorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateShortUriUseCase implements UseCase<String, String> {
    private UrlRepository urlRepository;
    private ShortCodeGeneratorService generatorService;

    public String execute(String originalUrl) {
        var shortUri = this.generatorService.generate();
        var url = Url.builder()
                .originalUrl(originalUrl)
                .shortedUri(shortUri)
                .build();
        this.urlRepository.save(url);
        return shortUri;
    }
}
