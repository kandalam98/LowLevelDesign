package org.example.RateLimiter.TokenBucket;

import org.example.RateLimiter.TokenBucket.UserBucketCreator;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        UserBucketCreator userBucketCreator = new UserBucketCreator(1);
        ExecutorService executors = Executors.newFixedThreadPool(12);
        for(int i=0;i<12;i++){
            Thread.sleep(1000);
            executors.execute(() -> userBucketCreator.accessApplication(2));

        }
        executors.shutdown();
    }
}
