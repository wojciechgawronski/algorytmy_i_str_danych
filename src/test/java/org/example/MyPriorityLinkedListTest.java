package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyPriorityLinkedListTest {

    @Test
    void insert() {
        MyPriorityLinkedList mpll = new MyPriorityLinkedList();

        mpll.insert(3, 3);
        mpll.insert(33, 3);
        mpll.insert(1, 1);
        mpll.insert(2, 2);
        mpll.insert(11, 1);

        assertEquals(5, mpll.size());
        assertEquals(1, mpll.remove());
        assertEquals(11, mpll.remove());
        assertEquals(2, mpll.remove());
        assertEquals(3, mpll.remove());
        assertEquals(33, mpll.remove());
    }

    @Test
    void remove() {
        MyPriorityLinkedList mpll = new MyPriorityLinkedList();

        mpll.insert(3, 3);
        mpll.insert(33, 3);
        mpll.insert(1, 1);
        mpll.insert(2, 2);
        mpll.insert(11, 1);

        assertEquals(1, mpll.remove());
        assertEquals(11, mpll.remove());
        assertEquals(2, mpll.remove());
        assertEquals(3, mpll.remove());
        assertEquals(33, mpll.remove());
    }

    @Test
    void get() {
        MyPriorityLinkedList mpll = new MyPriorityLinkedList();
        mpll.insert(3, 3);
        assertEquals(3, mpll.get());
        mpll.insert(1, 1);
        assertEquals(1, mpll.get());
        assertEquals(2, mpll.size());
    }

    @Test
    void isEmty() {
        MyPriorityLinkedList mpll = new MyPriorityLinkedList();
        assertEquals(true, mpll.isEmty());
        mpll.insert(3, 3);
        assertEquals(false, mpll.isEmty());
    }
}