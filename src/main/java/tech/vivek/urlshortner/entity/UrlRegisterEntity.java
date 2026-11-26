package tech.vivek.urlshortner.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="url_shortner")
public class UrlRegisterEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private UUID id;

    @Column(name = "original_url", nullable = false, columnDefinition = "TEXT")
    private String originalUrl;

    @Column(name="short_code", nullable = false, unique = true, length = 10)
    private String shortCode;

    @Column(name="created_at" , nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name="expires_at")
    private LocalDateTime expiresAt;

    @Column(name = "click_count", nullable = false)
    private Long clickCount = 0L;

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.expiresAt = this.createdAt.plusDays(10);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getOriginal_url() {
        return originalUrl;
    }

    public void setOriginal_url(String original_url) {
        this.originalUrl = original_url;
    }

    public String getShort_code() {
        return shortCode;
    }

    public void setShort_code(String short_code) {
        this.shortCode = short_code;
    }

    public LocalDateTime getCreated_at() {
        return createdAt;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.createdAt = created_at;
    }

    public Long getClick_count() {
        return clickCount;
    }

    public void setClick_count(Long click_count) {
        this.clickCount = click_count;
    }

    public LocalDateTime getExpires_at() {
        return expiresAt;
    }

    public void setExpires_at(LocalDateTime expires_at) {
        this.expiresAt = expires_at;
    }
}
