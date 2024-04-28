package org.example;

public class QueueInt implements QueueIntInterface {
    private int capacity;

    /**
     * array index of queue head
     */
    private int head = 0;
    private int[] array;

    public QueueInt(int capacity)
    {
        this.capacity = capacity;
        array = new int[capacity];
    }

    public void enqueue(int num){
        if (isFull()) {
            System.out.println("\nQueue is full! Cannot enqueue!\n");
            return;
        }

        array[head] = num;
        head++;
    }

    public Integer tail()
    {
        if (!isEmpty()) {
            return array[head-1];
        }
        return null;
    }

    /**
     * show first element in que
     * @return Ineger if is not empty, null atherwise
     */
    public Integer head()
    {
        if (isEmpty())
            return null;
        return array[0];
    }

    /**
     *
     * @return int if queue is not empty, null otherwise
     */
    public Integer dequeue()
    {
        if (isEmpty()) {
            // System.out.println("Queue is empty! Cannot dequeue");
            return null;
        }

        int item = array[0];
        for (int i = 0; i < head -1; i++) {
            array[i] = array[i+1];
        }
        this.head--;
        return item;
    }

    public boolean isEmpty()
    {
        return head == 0;
    }

    public boolean isFull()
    {
        return this.head == this.capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return head;
    }

    public void print()
    {
        System.out.println("==== PRINT QUEUE: size: "+getSize()+" capacity: "+capacity);
        if (isEmpty())
            System.out.println("[QUEUE IS EMPTY]");
        else {
            for (int i = 0; i < head; i++) {
                System.out.println("["+i+"]: "+array[i]);
            }
        }
        System.out.println("==== END QUEUE");
    }
}