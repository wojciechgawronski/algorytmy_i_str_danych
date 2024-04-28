package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void size() {
        LinkedList lj = new LinkedList<>();

        lj.addFirst(111);
        lj.addFirst(333);
        lj.addLast(444);

        assertEquals(3, lj.size());
    }

    @Test
    void isEmpty() {
        LinkedList lj = new LinkedList<>();
        assertTrue(lj.isEmpty());
    }

    @Test
    void front() {
        LinkedList lj = new LinkedList<>();

        lj.addFirst(111);
        assertEquals(111, lj.front());

        lj.addFirst(222);
        lj.addFirst(333);
        assertEquals(333, lj.front());
    }

    @Test
    void last() {
        LinkedList lj = new LinkedList<>();

        lj.addFirst(111);
        assertEquals(111, lj.last());

        lj.addFirst(222);
        lj.addFirst(333);
        assertEquals(111, lj.last());
    }

    @Test
    void addFirst() {
        LinkedList lj = new LinkedList<>();

        lj.addFirst(111);
        assertEquals(111, lj.front());
        lj.addFirst(222);
        assertEquals(222, lj.front());
    }

    @Test
    void addLast() {
        LinkedList lj = new LinkedList<>();

        lj.addLast(111);
        assertEquals(111, lj.last());
        assertEquals(111, lj.front());

        lj.addLast(222);
        lj.addLast(333);
        assertEquals(111, lj.front());
        assertEquals(333, lj.last());
    }

    @Test
    void removeFirst() {
        LinkedList lj = new LinkedList<>();

        lj.addFirst(111);
        assertEquals(111, lj.removeFirst());
        lj.addFirst(222);
        lj.addFirst(333);
        lj.addLast(444);
        assertEquals(333, lj.removeFirst());
    }
}