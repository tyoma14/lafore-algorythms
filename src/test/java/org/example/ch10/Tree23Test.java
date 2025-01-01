package org.example.ch10;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class Tree23Test {

    @Test
    void test() {
        Tree23<Integer> tree23 = new Tree23<Integer>(Comparator.naturalOrder());

        tree23.insert(50);
        tree23.insert(40);
        tree23.insert(60);
        tree23.insert(30);
        tree23.insert(70);

        tree23.displayTree();

        int found = tree23.find(40);
        System.out.println("Found 40 in " + found + " position");

        tree23.insert(20);
        System.out.println("Tree after 20 inserted:");
        tree23.displayTree();

        tree23.insert(10);
        System.out.println("Tree after 10 inserted:");
        tree23.displayTree();

        tree23.insert(15);
        System.out.println("Tree after 15 inserted:");
        tree23.displayTree();

        tree23.insert(55);
        System.out.println("Tree after 55 inserted:");
        tree23.displayTree();

        tree23.insert(57);
        System.out.println("Tree after 57 inserted:");
        tree23.displayTree();

        tree23.insert(58);
        System.out.println("Tree after 58 inserted:");
        tree23.displayTree();
    }

}