package org.example.ch4;

/**
 * Created by Artyom Zheltyshev on 18.06.2024
 */
public class Queue<T> {

    private int maxSize;
    private T[] queArray;
    private int front;
    private int rear;
    private int nItems;

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        this.queArray = (T[]) new Object[maxSize];
        this.front = 0;
        this.rear = -1;
        this.nItems = 0;
    }

    public void insert(T element) {
        if (rear == maxSize-1) {
            rear = -1;
        }
        queArray[++rear] = element;
        nItems++;
    }

    public T remove() {
        T temp = queArray[front++];
        if (front == maxSize) {
            front = 0;
        }
        nItems--;
        return temp;
    }

    public T peekFront() {
        return queArray[front];
    }

    public boolean isEmpty() {
        return nItems == 0;
    }

    public boolean isFull() {
        return nItems == maxSize;
    }

    public int size() {
        return nItems;
    }
}
