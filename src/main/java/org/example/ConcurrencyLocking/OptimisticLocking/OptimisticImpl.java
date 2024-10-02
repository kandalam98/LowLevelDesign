package org.example.ConcurrencyLocking.OptimisticLocking;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class OptimisticImpl {
    private static AtomicInteger counter = new AtomicInteger(0);
    private static int version = 0;
    public OptimisticImpl() throws InterruptedException {
        startOptimistic();
    }

    private void startOptimistic() throws InterruptedException {
        int numThreads = 20;
        Thread[] threads = new Thread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(() -> {
                int localCounter;

                do {
                    localCounter = counter.get(); // Get the current counter value

                    // Compare-and-swap operation
                } while (!counter.compareAndSet(localCounter, localCounter + 1));
            });

            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Counter value after optimistic locking: " + counter);
    }
}
