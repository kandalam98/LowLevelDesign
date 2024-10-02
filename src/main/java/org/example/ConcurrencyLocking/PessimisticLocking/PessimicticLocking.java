package org.example.ConcurrencyLocking.PessimisticLocking;

import java.util.concurrent.locks.ReentrantLock;

public class PessimicticLocking {
    public PessimicticLocking() {
        try {
            startPessimistic();
        }catch (Exception ex){
            System.out.println("Exception in Pessimistic Locking "+ ex.getMessage());
        }
    }
    private static int counter = 0;
    private static final ReentrantLock lock = new ReentrantLock();

    private void startPessimistic() throws InterruptedException {
        Thread[] threads = new Thread[200];

        for (int i = 0; i < 200; i++) {
            threads[i] = new Thread(() -> {
                lock.lock();
                try {
                    counter++;
                } finally {
                    lock.unlock();
                }
            });

            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Counter with lock (pessimistic locking): " + counter);
    }
}
