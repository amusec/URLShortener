package tech.vivek.urlshortner.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.vivek.urlshortner.dto.UrlRegisterDto;
import tech.vivek.urlshortner.dto.UrlRegisterResponseDto;
import tech.vivek.urlshortner.service.UrlService;

import java.net.URI;

@RestController
@RequestMapping("/")
public class UrlController {
    private UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping("/create")
    public ResponseEntity<UrlRegisterResponseDto> createUrl(@Valid @RequestBody UrlRegisterDto urlRegisterDto) {
        UrlRegisterResponseDto urlRegisterResponseDto = urlService.createShortUrl(urlRegisterDto);
        return ResponseEntity.ok(urlRegisterResponseDto);
    }

    @GetMapping("/{short_code}")
    public ResponseEntity<String> redirectUrl(@PathVariable String short_code) {
        String redirectUrl = urlService.redirectUrl(short_code);
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(redirectUrl)).body(redirectUrl);
    }

}
