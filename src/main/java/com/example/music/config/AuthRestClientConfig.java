package com.example.music.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;


@Configuration
public class AuthRestClientConfig {

    @Bean
    public RestClient authRestClient() {
        return RestClient.builder()
                .baseUrl("https://accounts.spotify.com/api/token")
                .build();
    }
}
