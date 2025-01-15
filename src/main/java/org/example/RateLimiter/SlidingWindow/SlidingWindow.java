package org.example.RateLimiter.SlidingWindow;

import java.util.Queue;

public class SlidingWindow {

    Queue<Long> queue;
    int timeInWidnow;

    public SlidingWindow(int timeInWidnow, int capacity) {
        this.timeInWidnow = timeInWidnow;
        this.capacity = capacity;
    }

    int capacity;

    boolean grandAccess(){
        long currTime =  System.currentTimeMillis();
        refreshAndUpdate(currTime);
        if(queue.size() < capacity){
            queue.offer(currTime);
            return true;
        }
        return false;
    }

    private void refreshAndUpdate(long currTime) {
        if(queue.isEmpty())return;
        int calTime = (int) ((currTime - queue.peek())/1000);
        while(calTime >= timeInWidnow){
            queue.poll();
            if(queue.isEmpty())break;
            calTime = (int) ((currTime - queue.peek())/1000);
        }
    }

}
