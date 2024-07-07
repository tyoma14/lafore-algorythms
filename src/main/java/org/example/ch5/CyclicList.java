package org.example.ch5;

/**
 * Created by Artyom Zheltyshev on 06.07.2024
 * Циклический односвязный список
 */
public class CyclicList<T> {

    private Link<T> current;

    public void shift() {
        current = current.next;
    }

    public T getCurrent() {
        return current.data;
    }

    public void insert(T element) {
        Link<T> newLink = new Link<>(element);
        if (current == null) {
            newLink.next = newLink;
            current = newLink;
        } else {
            newLink.next = current.next;
            current.next = newLink;
        }
    }

    public Link<T> find(T element) {
        Link<T> start = current.next;
        Link<T> findCurr = start;
        while (!findCurr.data.equals(element)) {
            if (findCurr.next == start) {
                return null;
            }
            findCurr = findCurr.next;
        }
        return findCurr;
    }

    public T delete(T element) {
        Link<T> start = current.next;
        Link<T> deletePrev = current;
        Link<T> deleteCurr = start;
        while (!deleteCurr.data.equals(element)) {
            if (deleteCurr.next == start) {
                return null;
            }
            deletePrev = deletePrev.next;
            deleteCurr = deleteCurr.next;
        }
        if (deletePrev == deleteCurr) {
            current = null;
        } else {
            deletePrev.next = deleteCurr.next;
            current = deletePrev;
        }
        return deleteCurr.data;
    }

    public T deleteNext() {
        if (current == null) {
            throw new IllegalStateException("Circle list is empty");
        }
        T temp;
        if (current.next == current) {
            temp = current.data;
            current = null;
        } else {
            temp = current.next.data;
            current.next = current.next.next;
        }
        return temp;
    }

    public boolean isSingleElement() {
        return current != null && current.next == current;
    }

    public void display() {
        System.out.print("Cyclic list: ");
        if (current == null) {
            System.out.print("[]");
            return;
        }
        Link<T> start = current.next;
        Link<T> displayCurr = start;
        System.out.print("[");
        while (true) {
            displayCurr.displayData();
            if (displayCurr.next == start) {
                break;
            }
            System.out.print(",");
            displayCurr = displayCurr.next;
        }
        System.out.println("]");
        System.out.println();
    }

}
