package com.montebello.noivern.API.Middlewares;

import com.montebello.noivern.API.RateLimit.RateLimiterAspect;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RateLimiterAspect.RateLimitException.class)
    public ResponseEntity<String> handleRateLimitException(RateLimiterAspect.RateLimitException e) {
        return ResponseEntity.status(429).body("Rate limit exceeded");
    }
}
