package com.example.music;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
@Service
@RequiredArgsConstructor
public class SearchService {
    private final RestClient spotifyClient;

    public Object search(
            String q,
            String type,
            String market,
            Integer limit,
            Integer offset
    ) {
        // /search?q=q&type=type&...
        String url = UriComponentsBuilder.fromUriString("/search")
                .queryParam("q", q)
                .queryParam("type", type)
                .queryParam("market", market)
                .queryParam("limit", limit)
                .queryParam("offset", offset)
                .build(false)
                .toUriString();
        // Bearer Token 준비
//        String tokenHeaderValue
//                = "Bearer " + tokenService.getToken();
        return spotifyClient.get()
                .uri(url)
//                .header("Authorization", tokenHeaderValue)
                .retrieve()
                .body(Object.class);
    }
}