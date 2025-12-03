package com.shortly.shortly_url.app.usecase;

import com.shortly.shortly_url.domain.model.Url;
import com.shortly.shortly_url.domain.repository.UrlRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ResolveShortedUriUseCase implements UseCase<String, String>{
    private UrlRepository urlRepository;

    @Override
    public String execute(String shortedUri) {
        var uri = urlRepository.getByShortedUri(shortedUri);
        return uri.map(Url::getOriginalUrl).orElse(null);
    }
}
