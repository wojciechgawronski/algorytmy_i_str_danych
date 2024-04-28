package org.example;

public class MyPriorityLinkedList<E> {

    private static class Node<E>
    {
        private E element;
        private Node<E> next;
        private int priority;

        public Node(E element, Node<E> next, int priority)
        {
            this.element = element;
            this.next = next;
            this.priority = priority;
        }

        public E getElement(){
            return this.element;
        }
    } // end class Node

    private Node<E> head = null;
    private int size = 0;

    public void insert(E element, int priority)
    {
        Node<E> newNode = new Node<>(element, null, priority);

        if (head == null || priority < head.priority)
        {
            newNode.next = head;
            head = newNode;
        } else {
            Node<E> current = head;
            // czy istnieje kolejny wezel na liscie: current.next != null
            // czy priorytet kolejnego wezla jest <= priot. nowego wezla
            while (current.next != null && current.next.priority <= priority) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        this.size++;
    }

    public E remove()
    {
        if (isEmty())
            throw new IllegalStateException("The priority list is empty");

        E removedElement = head.getElement();
        head = head.next;
        size--;
        return removedElement;
    }

    public E get()
    {
        if (isEmty())
            throw new IllegalStateException("The priority list is empty");

        return head.getElement();
    }

    public boolean isEmty()
    {
        return size == 0;
    }
}
