package com.whitesource.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * A thread-safe counter backed by an {@link AtomicInteger}.
 * Demonstrates the use of atomic operations for lock-free concurrency.
 */
public class ThreadSafeCounter {

    private final AtomicInteger count = new AtomicInteger(0);

    /** Increments the counter by one and returns the updated value. */
    public int increment() {
        return count.incrementAndGet();
    }

    /** Decrements the counter by one and returns the updated value. */
    public int decrement() {
        return count.decrementAndGet();
    }

    /** Resets the counter to zero. */
    public void reset() {
        count.set(0);
    }

    /** Returns the current value of the counter. */
    public int get() {
        return count.get();
    }
}
