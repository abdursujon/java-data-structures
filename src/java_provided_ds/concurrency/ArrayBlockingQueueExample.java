package concurrency;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * A bounded, thread-safe queue backed by an array (java.util.concurrent).
 * 1. bounded: fixed capacity set once at construction, can't grow (unlike LinkedBlockingQueue)
 * 2. multiple threads adding/removing items safely. blocking threads when the queue is full (put) or empty (take)
 * 3. put()/take() blocks but offer()/poll() don't block instead they return false/null or time out
 * <p>
 * Two most important purpose of ArrayBlockingQueue
 * <p>
 * 1. Fixed size, backed by an array. We set the capacity when we create it
 * and it never changes. new ArrayBlockingQueue<>(3) holds at most 3 items, ever.
 * <p>
 * 2. It blocks access when needed.
 * - If the queue is full and a thread calls put(),
 * that thread waits (sleeps) until another thread removes something.
 * - If the queue is empty and a thread calls take(), that thread waits
 * until another thread adds something.
 * </p>
 * *
 * Note: put()/take() blocks, but offer()/poll() do not — they return
 * false/null or time out instead.
 */
public class ArrayBlockingQueueExample {
    public static void main(String[] args) throws InterruptedException {
        // 1. bounded: fixed capacity set once at construction, can't grow (unlike LinkedBlockingQueue)
        ArrayBlockingQueue<String> orders = new ArrayBlockingQueue<>(3);

        // 2. multiple threads adding/removing items safely. blocking threads when the queue is full (put) or empty (take)
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    // 3. put() blocks when the queue is full (after 3 items)
                    orders.put("Order: " + i);
                    System.out.println("added order: " + i);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {
            try{
                for(int i = 1; i <= 5; i++){
                    Thread.sleep(300);
                    // 3. take() blocks when the queue is empty
                    System.out.println("processed: " + orders.take());
                }
            } catch(InterruptedException e){
                Thread.currentThread().interrupted();
            }
        });

        producer.start();
        consumer.start();
        // calling join() makes the current thread wait until the thread we call before finishes it jobs.
        producer.join();
        consumer.join();

        // 4. offer()/poll() do not block, they return a value instead
        System.out.println("Extra order was processed: " + orders.offer("Extra order: 5"));
        System.out.println("Extra order was processed: " + orders.offer("Extra order: 6"));
        System.out.println("Extra order was processed: " + orders.offer("Extra order: 7"));
        // queue is full so returns false
        System.out.println("Extra order was processed: " + orders.offer("Extra order: 8"));
        // removed without waiting
        System.out.println(orders.poll());
        System.out.println(orders.poll());
        System.out.println(orders.poll());
        // null, queue empty, returns immediately
        System.out.println(orders.poll());
    }
}