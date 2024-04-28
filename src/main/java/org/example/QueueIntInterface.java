package org.example;

public interface QueueIntInterface {
    void enqueue(int num);
    Integer dequeue();

    Integer tail();

    Integer head();

    boolean isEmpty();
}