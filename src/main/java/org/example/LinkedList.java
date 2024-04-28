package org.example;

public class LinkedList<E> {
    private static class Node<E>
    {
        /**
         * pointer to element in Node
         */
        private E element;

        /**
         * pointer to next element
         */
        private Node <E> next;

        /**
         *
         * @param element node element
         * @param next pointer to next Node
         */
        public Node(E element, Node<E> next)
        {
            this.element = element;
            this.next = next;
        }

        public E getElement()
        {
            return this.element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    } // end node Class

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public LinkedList() {}

    public int size() { return size;}
    public boolean isEmpty(){return size == 0;}

    /**
     * only return first element of List if not empty
     *
     * @return <E> if list is not empty, null otherwise
     */
    public E front()
    {
        if (isEmpty()) return null;
        return head.getElement();
    }

    /**
     * only return last element of List if not empty
     *
     * @return <E> if list is not empty, null otherwise
     */
    public E last()
    {
        if (isEmpty())
            return null;

        Node<E> current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current.getElement();
    }

    public void addFirst(E element)
    {
        Node<E> newNode = new Node<>(element, null);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    /**
     * add generic element on tail of list
     *
     * @param element
     */
    public void addLast(E element)
    {
        Node<E> newNode = new Node<>(element, null);
        if (isEmpty())
            head = tail = newNode;
        else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    /**
     * removes and returns first element of list
     *
     * @return E element
     */
    public E removeFirst()
    {
        if (isEmpty())
            return null;

        E temp = head.getElement();
        head = head.getNext();
        size--;

        if (isEmpty())
            tail = null;

        return temp;
    }
}