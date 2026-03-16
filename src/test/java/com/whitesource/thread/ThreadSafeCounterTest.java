package com.whitesource.thread;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ThreadSafeCounterTest {

    private ThreadSafeCounter counter;

    @BeforeEach
    void setUp() {
        counter = new ThreadSafeCounter();
    }

    @Test
    void initialValueIsZero() {
        assertEquals(0, counter.get());
    }

    @Test
    void incrementReturnsUpdatedValue() {
        assertEquals(1, counter.increment());
        assertEquals(2, counter.increment());
    }

    @Test
    void decrementReturnsUpdatedValue() {
        counter.increment();
        counter.increment();
        assertEquals(1, counter.decrement());
        assertEquals(0, counter.decrement());
    }

    @Test
    void resetSetsValueToZero() {
        counter.increment();
        counter.increment();
        counter.reset();
        assertEquals(0, counter.get());
    }

    @Test
    void concurrentIncrementsAreConsistent() throws Exception {
        int threadCount = 10;
        int incrementsPerThread = 1000;
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);

        List<Future<?>> futures = new ArrayList<>();
        for (int i = 0; i < threadCount; i++) {
            futures.add(executor.submit(() -> {
                for (int j = 0; j < incrementsPerThread; j++) {
                    counter.increment();
                }
            }));
        }

        for (Future<?> future : futures) {
            future.get();
        }
        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);

        assertEquals(threadCount * incrementsPerThread, counter.get());
    }
}
