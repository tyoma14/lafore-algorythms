package org.example.ch4;

import org.junit.jupiter.api.Test;

/**
 * Created by Artyom Zheltyshev on 18.06.2024
 */
class QueueTest {

    @Test
    void test() {
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
}