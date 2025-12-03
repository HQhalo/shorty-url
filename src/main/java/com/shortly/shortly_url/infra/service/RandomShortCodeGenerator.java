package com.shortly.shortly_url.infra.service;

import com.shortly.shortly_url.domain.service.ShortCodeGeneratorService;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomShortCodeGenerator implements ShortCodeGeneratorService {
    public String generate(){
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(6);
        for (int i = 0; i < 6; i++) {
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        }
        return sb.toString();
    }
}
