package org.example.RateLimiter.LeakyBucket;

import org.example.RateLimiter.RateLimiter;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class LeakyBucket implements RateLimiter {
    LinkedBlockingDeque<Integer> queue;

    public LeakyBucket(int size) {
        this.queue = new LinkedBlockingDeque<>(size);
    }

    @Override
    public boolean grantAccess() {
        if(queue.remainingCapacity() > 0){
            queue.add(1);
            return true;
        }
        return false;
    }
}
