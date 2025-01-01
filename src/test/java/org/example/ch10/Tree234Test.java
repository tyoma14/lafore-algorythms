package org.example.ch10;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class Tree234Test {

    @Test
    void test() {
        Tree234<Integer> tree234 = new Tree234<Integer>(Comparator.naturalOrder());

        tree234.insert(50);
        tree234.insert(40);
        tree234.insert(60);
        tree234.insert(30);
        tree234.insert(70);

        tree234.displayTree();

        int found = tree234.find(40);
        System.out.println("Found 40 in " + found + " position");

        tree234.insert(20);
        System.out.println("Tree after 20 inserted:");
        tree234.displayTree();

        tree234.insert(10);
        System.out.println("Tree after 10 inserted:");
        tree234.displayTree();

        Integer min = tree234.getMin();
        System.out.println("Min element: " + min);

        System.out.print("Symmetric traversal:");
        tree234.traverse();
    }
}