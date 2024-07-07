package org.example.ch5;

import java.util.Comparator;

/**
 * Created by Artyom Zheltyshev on 30.06.2024
 * Сортированный односвязный список
 */
public class SortedList<T> {

    private Link<T> first;
    private Comparator<T> comparator;

    public SortedList(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public SortedList(Comparator<T> comparator, T[] arr) {
        this.comparator = comparator;
        for (int j = 0; j < arr.length; j++) {
            insert(arr[j]);
        }
    }

    public static <T extends Comparable<T>> SortedList<T> withNaturalOrder() {
        return new SortedList<T>(Comparator.naturalOrder());
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insert(T element) {
        Link<T> newLink = new Link<>(element);
        Link<T> previous = null;
        Link<T> current = first;

        while (current != null && comparator.compare(element, current.data) > 0) {
            previous = current;
            current = current.next;
        }
        if (previous == null) {
            first = newLink;
        } else {
            previous.next = newLink;
        }
        newLink.next = current;
    }

    public Link<T> remove() {
        Link<T> temp = first;
        first = first.next;
        return temp;
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
