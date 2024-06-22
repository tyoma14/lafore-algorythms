package org.example.ch4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Artyom Zheltyshev on 18.06.2024
 */
class QueueTest {

    @Test
    void insertAndRemove() {
        Queue<Integer> theQueue = new Queue<>(5);

        theQueue.insert(10);
        theQueue.insert(20);
        theQueue.insert(30);
        theQueue.insert(40);

        theQueue.remove();
        theQueue.remove();
        theQueue.remove();

        theQueue.insert(50);
        theQueue.insert(60);
        theQueue.insert(70);
        theQueue.insert(80);

        while (!theQueue.isEmpty()) {
            Integer n = theQueue.remove();
            System.out.println(n);
        }
    }

    @Test
    void iterate() {
        Queue<Integer> theQueue = new Queue<>(5);

        theQueue.insert(10);
        theQueue.insert(20);
        theQueue.insert(30);
        theQueue.insert(40);

        ArrayList<Integer> output = new ArrayList<>();
        for (Integer item : theQueue) {
            output.add(item);
        }

        Assertions.assertEquals(List.of(10, 20, 30, 40), output);
    }

    @Test
    void iterateWithCarry() {
        Queue<Integer> theQueue = new Queue<>(5);

        theQueue.insert(10);
        theQueue.insert(20);
        theQueue.insert(30);
        theQueue.insert(40);

        theQueue.remove();
        theQueue.remove();
        theQueue.remove();

        theQueue.insert(50);
        theQueue.insert(60);
        theQueue.insert(70);
        theQueue.insert(80);

        ArrayList<Integer> output = new ArrayList<>();
        for (Integer item : theQueue) {
            output.add(item);
        }

        Assertions.assertEquals(List.of(40, 50, 60, 70, 80), output);
    }
}