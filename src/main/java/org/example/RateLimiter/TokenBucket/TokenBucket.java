package org.example.RateLimiter.TokenBucket;

import org.example.RateLimiter.RateLimiter;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class TokenBucket implements RateLimiter {
    int bucketCapacity;
    int refreshRate;

    private AtomicInteger currentCapacity;
    private AtomicLong lastUpdatedTime;

    public TokenBucket(int bucketCapacity, int refreshRate) {
        this.bucketCapacity = bucketCapacity;
        this.refreshRate = refreshRate;
        currentCapacity = new AtomicInteger(bucketCapacity);
        lastUpdatedTime = new AtomicLong(System.currentTimeMillis());
    }

    @Override
    public boolean grantAccess() {
        refreshToken();
        if(currentCapacity.get() > 0){
            currentCapacity.decrementAndGet();
            return true;
        }
        return false;
    }

    private void refreshToken() {
        int current = (int) System.currentTimeMillis();
        int newTokens = (int) ((( current - lastUpdatedTime.get() ) / 100 ) * refreshRate);
        int totalTokens = Math.max(bucketCapacity , newTokens + currentCapacity.get());
        currentCapacity.getAndSet(totalTokens);
        lastUpdatedTime.getAndSet(current);
    }
}
