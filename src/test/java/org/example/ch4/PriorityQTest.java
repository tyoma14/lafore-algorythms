package org.example.ch4;

import org.junit.jupiter.api.Test;

/**
 * Created by Artyom Zheltyshev on 18.06.2024
 */
class PriorityQTest {

    @Test
    void test() {
        PriorityQ<Integer> q = PriorityQ.withNaturalOrder(5);
        q.insert(30);
        q.insert(50);
        q.insert(10);
        q.insert(40);
        q.insert(20);

        while (!q.isEmpty()) {
            Integer item = q.remove();
            System.out.println(item);
        }
    }
}