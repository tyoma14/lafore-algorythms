package org.example.ch5;

/**
 * Created by Artyom Zheltyshev on 30.06.2024
 * Связный список
 */
public class LinkList<T> {

    private Link<T> first;

    public LinkList() {
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(T element) {
        Link<T> newLink = new Link<>(element);
        newLink.next = first;
        first = newLink;
    }

    public Link<T> deleteFirst() {
        Link<T> temp = first;
        first = first.next;
        return temp;
    }

    public Link<T> find(T element) {
        Link<T> current = first;
        while (!current.data.equals(element)) {
            if (current.next == null) {
                return null;
            } else {
                current = current.next;
            }
        }
        return current;
    }

    public Link<T> delete(T element) {
        Link<T> previous = first;
        Link<T> current = first;
        while (!current.data.equals(element)) {
            if (current.next == null) {
                return null;
            }
            previous = current;
            current = current.next;
        }
        if (current == first) {
            first = previous;
        } else {
            previous.next = current.next;
        }
        return current;
    }

    public void displayList() {
        System.out.print("List (first-->last): ");
        Link<T> current = first;
        System.out.print("[");
        while (current != null) {
            current.displayData();
            current = current.next;
            if (current != null) {
                System.out.print(",");
            }
        }
        System.out.println("]");
        System.out.println();
    }
}
