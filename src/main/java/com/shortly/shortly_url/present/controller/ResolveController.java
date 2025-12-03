package com.shortly.shortly_url.present.controller;

import com.shortly.shortly_url.app.usecase.ResolveShortedUriUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ResolveController {
    private final ResolveShortedUriUseCase resolveShortedUriUseCase;

    @GetMapping("/{shortedUri}")
    public ResponseEntity<Void> redirect(@PathVariable String shortedUri){
        String originalUrl = resolveShortedUriUseCase.execute(shortedUri);
        if(originalUrl == null){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.FOUND)
                .header(HttpHeaders.LOCATION, originalUrl)
                .build();
    }
}
