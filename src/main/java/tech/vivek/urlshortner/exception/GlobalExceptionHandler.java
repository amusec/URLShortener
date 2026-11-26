    package tech.vivek.urlshortner.exception;

    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.ExceptionHandler;
    import org.springframework.web.bind.annotation.RestControllerAdvice;

    @RestControllerAdvice
    public class GlobalExceptionHandler {

        @ExceptionHandler(RuntimeException.class)
        public ResponseEntity<String> handleRuntimeException( RuntimeException ex ) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
        @ExceptionHandler(UrlNotFoundException.class)
        public ResponseEntity<String> handleUrlNotFound( UrlNotFoundException ex ) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No URL Found for "+ex.getShortCode());
        }

        @ExceptionHandler(UrlExpiredException.class)
        public ResponseEntity<String> handleUrlExpired( UrlExpiredException ex ) {
            return ResponseEntity.status(HttpStatus.GONE).body(ex.getMessage());
        }

    }
