package com.montebello.noivern.API.RateLimit;

public class TokenBucket {
    private int capacity;
    private int tokens;
    private long lastRefillTimestamp;
    private int refillRate;

    public TokenBucket(int capacity, int refillRate) {
        this.capacity = capacity;
        this.tokens = capacity;
        this.refillRate = refillRate;
        this.lastRefillTimestamp = System.currentTimeMillis();
    }

    public synchronized boolean tryConsume() {
        refill();
        if(tokens >= 1){
            tokens--;
            return true;
        }
        return false;
    }

    private void refill() {
        long now = System.currentTimeMillis();
        double tokensToAdd = (now - lastRefillTimestamp) / 1000.0 * refillRate;
        this.tokens = Math.min(capacity, (int) (tokens + tokensToAdd));
        this.lastRefillTimestamp = now;
    }
}
