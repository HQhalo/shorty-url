package com.shortly.shortly_url.domain.model;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Url {
    private Long id;
    private String originalUrl;
    private String shortedUri;
    private Integer userId;
    private LocalDateTime createdAt;
}
