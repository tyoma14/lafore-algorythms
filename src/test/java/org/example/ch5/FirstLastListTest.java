package org.example.ch5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Artyom Zheltyshev on 30.06.2024
 */
class FirstLastListTest {

    @Test
    void test() {
        FirstLastList<Integer> theList = new FirstLastList<>();

        theList.insertFirst(22);
        theList.insertFirst(44);
        theList.insertFirst(66);

        theList.insertLast(11);
        theList.insertLast(33);
        theList.insertLast(55);

        theList.displayList();

        theList.deleteFirst();
        theList.deleteFirst();

        theList.displayList();
    }
}