# Java Thread Architecture

Java high-concurrency programming and high-performance architecture examples.

## Project Structure

```
src/
  main/java/com/whitesource/thread/   # Production sources
  test/java/com/whitesource/thread/   # Unit tests
```

## Building & Testing

Requirements: Java 11+, Maven 3.6+

```bash
# Compile
mvn compile

# Run tests
mvn test
```

## Modules

| Class | Description |
|-------|-------------|
| `ThreadSafeCounter` | Lock-free atomic counter demonstrating `AtomicInteger` usage |
