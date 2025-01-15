package org.example.RateLimiter.TokenBucket;

import java.util.HashMap;
import java.util.Map;

public class UserBucketCreator {
    Map<Integer, TokenBucket> tokenBucketMap;

    public UserBucketCreator(int id) {
        this.tokenBucketMap = new HashMap<>();
        tokenBucketMap.put(id , new TokenBucket(1,100));
    }

    public void accessApplication(int id){
        if(tokenBucketMap.containsKey(id) && tokenBucketMap.get(id).grantAccess()){
            System.out.println(Thread.currentThread().getName() + " -> able to access the application");
        } else {
            System.out.println(Thread.currentThread().getName() + " -> Too many request, Please try after some time");
        }
    }
}
