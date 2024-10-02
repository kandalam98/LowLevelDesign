package org.example.ConcurrencyLocking.PessimisticLocking;

import java.util.concurrent.locks.ReentrantLock;

public class PessimisticWithoutLock {
    public PessimisticWithoutLock() {

        try {
            pessimisticWithoutLock();
        }catch (Exception ex){
            System.out.println("Exception in Pessimistic Locking "+ ex.getMessage());
        }
    }
    private static int counter = 0;
    private static final ReentrantLock lock = new ReentrantLock();

    /***
     * https://medium.com/@abhirup.acharya009/managing-concurrent-access-optimistic-locking-vs-pessimistic-locking-0f6a64294db7
     * Without Locking (Potential Race Condition)
     *
     * If pessimistic locking is not used, multiple transactions might interact with the counter concurrently without ensuring exclusive access.
     * This could lead to a race condition where the counter’s value becomes inconsistent due to concurrent modifications.
     */

    private void pessimisticWithoutLock() throws InterruptedException {
        int threadSize = 30000;
        Thread[] threads = new Thread[threadSize];

        for (int i = 0; i < threadSize; i++) {
            threads[i] = new Thread(() -> {
                counter++;
            });

            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Counter with lock (pessimistic without locking): " + counter);
    }
}
