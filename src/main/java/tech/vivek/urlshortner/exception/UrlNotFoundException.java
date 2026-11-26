package tech.vivek.urlshortner.exception;

public class UrlNotFoundException extends RuntimeException {
    private final String short_code;
    public String getShortCode() {
        return short_code;
    }
    public UrlNotFoundException(String code) {
        super("Url Not Found\t"+code);
        this.short_code = code;
    }
}
