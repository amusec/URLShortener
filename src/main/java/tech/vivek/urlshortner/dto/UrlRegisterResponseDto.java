package tech.vivek.urlshortner.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public class UrlRegisterResponseDto {
    private UUID id;
    private String original_url;
    private String short_code;
    private LocalDateTime created_at;
    private LocalDateTime expires_at;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getOriginal_url() {
        return original_url;
    }

    public void setOriginal_url(String original_url) {
        this.original_url = original_url;
    }

    public String getShort_code() {
        return short_code;
    }

    public void setShort_code(String short_code) {
        this.short_code = short_code;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getExpires_at() {
        return expires_at;
    }

    public void setExpires_at(LocalDateTime expires_at) {
        this.expires_at = expires_at;
    }
}
