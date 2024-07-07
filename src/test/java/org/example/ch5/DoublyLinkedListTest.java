package org.example.ch5;

import org.junit.jupiter.api.Test;

/**
 * Created by Artyom Zheltyshev on 03.07.2024
 */
class DoublyLinkedListTest {

    @Test
    void demo() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        list.insertFirst(22);
        list.insertFirst(44);
        list.insertFirst(66);

        list.insertLast(11);
        list.insertLast(33);
        list.insertLast(55);

        list.displayForward();
        list.displayBackward();

        list.deleteFirst();
        list.deleteLast();
        list.deleteKey(11);

        list.displayForward();

        list.insertAfter(22, 77);
        list.insertAfter(33, 88);

        list.displayForward();
    }
}