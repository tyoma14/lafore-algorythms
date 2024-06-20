package org.example.ch4;

/**
 * Created by Artyom Zheltyshev on 18.06.2024
 */
public class StackX<T> {

    private int maxSize;
    private T[] array;
    private int top;

    public StackX(int maxSize) {
        this.maxSize = maxSize;
        //noinspection unchecked
        this.array = (T[]) new Object[maxSize];
        this.top = -1;
    }

    public void push(T element) {
        array[++top] = element;
    }

    public T pop() {
        return array[top--];
    }

    public T peek() {
        return array[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    public T peekN(int n) {
        return array[n];
    }

    public void displayStack(String str) {
        System.out.print(str);
        System.out.print("Stack (bottom-->top): ");
        for (int i = 0; i < size(); i++) {
            System.out.print(peekN(i));
            System.out.print(' ');
        }
        System.out.println();
    }
}
