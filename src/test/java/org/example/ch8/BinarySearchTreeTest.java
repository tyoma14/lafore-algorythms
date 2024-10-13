package org.example.ch8;

import org.junit.jupiter.api.Test;

class BinarySearchTreeTest {

    @Test
    void test() {
        BinarySearchTree<Integer, Double> theTree = new BinarySearchTree<>();
        theTree.insert(50, 1.5);
        theTree.insert(25, 1.7);
        theTree.insert(75, 1.9);

        BinarySearchTree.Node<Integer, Double> found = theTree.find(25);
        if (found != null) {
            System.out.println("Found the node with key 25");
        } else {
            System.out.println("Could not find node with key 25");
        }
    }

}