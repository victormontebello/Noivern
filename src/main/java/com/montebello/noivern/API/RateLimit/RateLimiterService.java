package com.montebello.noivern.API.RateLimit;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class RateLimiterService {
    private final Map<String, TokenBucket> buckets = new ConcurrentHashMap<>();

    public boolean tryConsume(String key, int requests, int timeWindow) {
        TokenBucket bucket = buckets.computeIfAbsent(key, k -> new TokenBucket(requests, timeWindow));
        return bucket.tryConsume();
    }
}
