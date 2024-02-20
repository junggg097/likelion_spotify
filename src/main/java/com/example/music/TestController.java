package com.example.music;

import com.example.music.dto.AccessTokenDto;
import com.example.music.service.SpotifyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final SpotifyTokenService tokenService;
    private final SpotifyService spotifyService;

    @GetMapping("/test/token")
    public AccessTokenDto getAccessToken() {
        return tokenService.getAccessToken();
    }

    @GetMapping("/test/get-entity")
    public Object getEntity(
            @RequestParam("spotify_id")
            String id,
            @RequestParam("type")
            String type
    ) {
        /*
        switch (type) {
            case "album":
                return spotifyService.getAlbum(id);
            case "artist":
                return spotifyService.getArtist(id);
            case "track":
                return spotifyService.getTrack(id);
            default:
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
         */
        return switch (type) {
            case "album"-> spotifyService.getAlbum(id);
            case "artist"-> spotifyService.getArtist(id);
            case "track"-> spotifyService.getTrack(id);
            default -> throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        };
    }
}
