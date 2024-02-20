package com.example.music.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

import java.util.Map;

// Spotify에서 사용할 API들을 정리한다.

public interface SpotifyHttpInterface {
    @GetExchange("/search")
    Object search(@RequestParam Map<String , ?> params);

    // 앨범 찾기
    @GetExchange("/albums/{id}")
    Object getAlbums(@PathVariable("id") String id);

    // 아티스트 찾기
    @GetExchange("/artists/{id}")
    Object getArtist(@PathVariable("id") String id);

    // 노래 찾기
    @GetExchange("/tracks/{id}")
    Object getTrack(@PathVariable("id") String id);

}
