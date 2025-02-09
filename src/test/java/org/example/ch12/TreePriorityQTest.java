package org.example.ch12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreePriorityQTest {

    @Test
    void test() {
        TreePriorityQ priorityQ = new TreePriorityQ();

        priorityQ.insert(new Node(70)); // Вставка 10 items
        priorityQ.insert(new Node(40));
        priorityQ.insert(new Node(50));
        priorityQ.insert(new Node(20));
        priorityQ.insert(new Node(60));
        priorityQ.insert(new Node(100));
        priorityQ.insert(new Node(80));
        priorityQ.insert(new Node(30));
        priorityQ.insert(new Node(10));
        priorityQ.insert(new Node(90));

        priorityQ.printQ();

        priorityQ.insert(new Node(53));
        priorityQ.printQ();

        priorityQ.remove();
        priorityQ.printQ();
    }
}