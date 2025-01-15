package org.example.RateLimiter.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class UserBucket {
    Map<Integer,SlidingWindow> map;

    public UserBucket(int id) {
        this.map = new HashMap<>();
        this.map.put(id, new SlidingWindow(1,10));
    }

    void hasAccess(int id){
        if(map.get(id).grandAccess()){
            System.out.println(Thread.currentThread().getName() + " -> able to access the application");

        }else {
            System.out.println(Thread.currentThread().getName() + " -> able to access the application");
        }
    }
}
