package com.example.music;

import com.example.music.dto.AccessTokenDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClient;

import java.util.Map;

@Component
public class SpotifyTokenService {
    @Value("8ec5cc4c83c348e4a70323c8660d134c")
    private String clientId;
    @Value("${spotify.client-secret}")
    private String clientSecret;
    private final RestClient authRestClient;

    public SpotifyTokenService(RestClient authRestClient) {
        this.authRestClient = authRestClient;
    }

    public AccessTokenDto getAccessToken() {
        MultiValueMap<String, Object> parts = new LinkedMultiValueMap<>();
        parts.add("grant_type", "client_credentials");
        parts.add("client_id", clientId);
        parts.add("client_secret", clientSecret);

        return authRestClient.post()
                // Content-Type 헤더 설정
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(parts)
                .retrieve()
                .body(AccessTokenDto.class);
    }
}