package org.example;

import static org.junit.jupiter.api.Assertions.*;

class QueueIntTest {

    @org.junit.jupiter.api.Test
    void enqueue() {
        QueueInt queueInt = new QueueInt(3);
        queueInt.enqueue(11);
        assertEquals(11, queueInt.head());
        queueInt.enqueue(12);
        assertEquals(11, queueInt.head());
        queueInt.enqueue(13);
        assertEquals(11, queueInt.head());
        assertEquals(13, queueInt.tail());
        assertEquals(queueInt.getSize(), 3);
    }

    @org.junit.jupiter.api.Test
    void enqueueFullError() {
        QueueInt queueInt = new QueueInt(1);
        queueInt.enqueue(1);
        queueInt.enqueue(1);
    }

    @org.junit.jupiter.api.Test
    void dequeue() {
        QueueInt queueInt = new QueueInt(3);
        queueInt.enqueue(11);
        assertEquals(11, queueInt.dequeue());
        queueInt.enqueue(12);
        queueInt.enqueue(13);
        assertEquals(12, queueInt.dequeue());
        assertEquals(13, queueInt.dequeue());
    }

    @org.junit.jupiter.api.Test
    void head() {
        QueueInt queueInt = new QueueInt(2);
        queueInt.enqueue(11);
        queueInt.enqueue(12);
        assertEquals(11, queueInt.head());
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        QueueInt queueInt = new QueueInt(5);
        assertEquals(true, queueInt.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void isFull() {
        int qSize = 5;
        QueueInt queueInt = new QueueInt(qSize);
        for (int i = 0; i < qSize; i++){
            queueInt.enqueue(i);
        }
        assertTrue(queueInt.isFull());
    }

    @org.junit.jupiter.api.Test
    void getSize() {
        QueueInt queueInt = new QueueInt(5);
        queueInt.enqueue(11);
        assertEquals(1, queueInt.getSize());
        queueInt.enqueue(11);
        assertEquals(2, queueInt.getSize());
    }
}