package tech.vivek.urlshortner.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class UrlRegisterDto {
    private String url;

    @NotBlank(message = "URL is required")
    @Pattern(regexp = "^https?://.+$", message = "URL must start with http:// or https://")
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
}
