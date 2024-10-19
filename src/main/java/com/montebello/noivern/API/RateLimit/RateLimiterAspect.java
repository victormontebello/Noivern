package com.montebello.noivern.API.RateLimit;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RateLimiterAspect {
    private final RateLimiterService rateLimiterService;

    public RateLimiterAspect(RateLimiterService rateLimiterService) {
        this.rateLimiterService = rateLimiterService;
    }

     @Around("@annotation(rateLimiter)")
     public Object checkRateLimit(ProceedingJoinPoint joinPoint, RateLimiter rateLimiter) throws Throwable {
         String key = joinPoint.getSignature().toLongString();
         if (!rateLimiterService.tryConsume(key, rateLimiter.requests(), rateLimiter.timeWindow())) {
             throw new RateLimitException();
         }
         return joinPoint.proceed();
     }

    public static class RateLimitException extends RuntimeException {
        public RateLimitException() {
            super("Rate limit exceeded");
        }
    }

    private String generateKey(ProceedingJoinPoint joinPoint) {
        return joinPoint.getSignature().toLongString();
    }

}
