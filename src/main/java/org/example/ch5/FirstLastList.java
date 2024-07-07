package org.example.ch5;

/**
 * Created by Artyom Zheltyshev on 30.06.2024
 * Двусторонний список
 */
public class FirstLastList<T> {

    private Link<T> first;
    private Link<T> last;

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(T element) {
        Link<T> newLink = new Link<>(element);
        if (isEmpty()) {
            last = newLink;
        }
        newLink.next = first;
        first = newLink;
    }

    public void insertLast(T element) {
        Link<T> newLink = new Link<>(element);
        if (isEmpty()) {
            first = newLink;
        } else {
            last.next = newLink;
        }
        last = newLink;
    }

    public T deleteFirst() {
        Link<T> temp = first;
        if (first.next == null) {
            last = null;
        }
        first = first.next;
        return temp.data;
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
