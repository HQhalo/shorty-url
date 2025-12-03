package com.shortly.shortly_url.present.controller;

import com.shortly.shortly_url.app.usecase.CreateShortUriUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/url")
public class UrlController {
    private final CreateShortUriUseCase createShortUriUseCase;

    @PostMapping("/shorten")
    public String shorten(@RequestParam(name = "original-url") String originalUrl) {
        return createShortUriUseCase.execute(originalUrl);
    }
}
