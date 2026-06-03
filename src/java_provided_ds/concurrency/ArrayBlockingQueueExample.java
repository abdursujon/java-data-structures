package concurrency;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * A bounded, thread-safe queue backed by an array (java.util.concurrent).
 * 1. bounded: fixed capacity set once at construction, can't grow (unlike LinkedBlockingQueue)
 * 2. multiple threads adding/removing items safely
 * 3. blocking threads when the queue is full (put) or empty (take)
 * 4. put()/take() block; offer()/poll() don't block instead they return false/null or time out
 *
 * Two most important purpose of ArrayBlockingQueue
 * <p>
 *     1. Fixed size, backed by an array. We set the capacity when we create it
 *     and it never changes. new ArrayBlockingQueue<>(3) holds at most 3 items, ever.
 *
 *     2. It blocks access when needed.
 *     - If the queue is full and a thread calls put(),
 *       that thread waits (sleeps) until another thread removes something.
 *     - If the queue is empty and a thread calls take(), that thread waits
 *       until another thread adds something.
 * </p>
 *  *
 *  Note: put()/take() blocks, but offer()/poll() do not — they return
 *  false/null or time out instead.
 */
public class ArrayBlockingQueueExample {
    public static void main(String[] args){
        // 1. bounded: fixed capacity set once at construction, can't grow (unlike LinkedBlockingQueue)
        ArrayBlockingQueue<String> orders = new ArrayBlockingQueue<>(10);
        // 2. multiple threads adding/removing items safely
        // 3. blocking threads when the queue is full (put) or empty (take)
        // 4. put()/take() block; offer()/poll() don't block instead they return false/null or time out
    }
}