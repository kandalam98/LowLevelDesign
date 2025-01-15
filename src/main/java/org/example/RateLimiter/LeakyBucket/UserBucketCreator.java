package org.example.RateLimiter.LeakyBucket;

import java.util.HashMap;
import java.util.Map;

public class UserBucketCreator {
    Map<Integer,LeakyBucket> leakyBucketMap;

    public UserBucketCreator(int id) {
        this.leakyBucketMap = new HashMap<>();
        leakyBucketMap.put(id, new LeakyBucket(10));
    }

    void accessApplication(int id){
        if(leakyBucketMap.get(id).grantAccess()){
            System.out.println(Thread.currentThread().getName() + " -> able to access the application");
        }else {
            System.out.println(Thread.currentThread().getName() + " -> Too many request, Please try after some time");
        }
    }
}
