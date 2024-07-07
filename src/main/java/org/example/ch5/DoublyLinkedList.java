package org.example.ch5;

/**
 * Created by Artyom Zheltyshev on 02.07.2024
 * Двусторонний двусвязный список
 */
public class DoublyLinkedList<T> {

    private Node first;
    private Node last;

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(T element) {
        Node newNode = new Node(element);
        if (isEmpty()) {
            last = newNode;
        } else {
            newNode.next = first;
            first.previous = newNode;
        }
        first = newNode;
    }

    public void insertLast(T element) {
        Node newNode = new Node(element);
        if (isEmpty()) {
            first = newNode;
        } else {
            newNode.previous = last;
            last.next = newNode;
        }
        last = newNode;
    }

    public T deleteFirst() {
        Node temp = first;
        if (first.next == null) {
            last = null;
        } else {
            first.next.previous = null;
        }
        first = first.next;
        return temp.data;
    }

    public T deleteLast() {
        Node temp = last;
        if (last.previous == null) {
            first = null;
        } else {
            last.previous.next = null;
        }
        last = last.previous;
        return temp.data;
    }

    public boolean insertAfter(T key, T dd) {
        Node current = first;
        while (!current.data.equals(key)) {
            current = current.next;
            if (current == null) {
                return false;
            }
        }
        Node newNode = new Node(dd);
        if (current == last) {
            last = newNode;
        } else {
            newNode.next = current.next;
            current.next.previous = newNode;
        }
        newNode.previous = current;
        current.next = newNode;
        return true;
    }

    public T deleteKey(T key) {
        Node current = first;
        while (!current.data.equals(key)) {
            current = current.next;
            if (current == null) {
                return null;
            }
        }

        if (current == first) {
            first = current.next;
        } else {
            current.previous.next = current.next;
        }

        if (current == last) {
            last = current.previous;
        } else {
            current.next.previous = current.previous;
        }

        return current.data;
    }

    public void displayForward() {
        System.out.print("List (first-->last): ");
        Node current = first;
        while (current != null) {
            current.displayData();
            current = current.next;
        }
        System.out.println();
    }

    public void displayBackward() {
        System.out.print("List (last-->first): ");
        Node current = last;
        while (current != null) {
            current.displayData();
            current = current.previous;
        }
        System.out.println();
    }

    class Node {
        T data;
        Node next;
        Node previous;

        Node(T data) {
            this.data = data;
        }

        void displayData() {
            System.out.print(data + " ");
        }
    }

}
