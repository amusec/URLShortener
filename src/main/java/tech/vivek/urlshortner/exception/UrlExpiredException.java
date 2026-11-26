package tech.vivek.urlshortner.exception;

public class UrlExpiredException extends RuntimeException {
    public UrlExpiredException() {
        super("URL is expired!");
    }
}
