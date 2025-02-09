package org.example.ch12;

import org.example.ch8.BinarySearchTree;

/**
 * Приоритетная очередь на базе двоичного дерева поиска
 */
public class TreePriorityQ {

    private BinarySearchTree<Integer, Node> tree = new BinarySearchTree<>();

    public void insert(Node node) {
        tree.insert(node.getKey(), node);
    }

    public Node remove() {
        return tree.removeMax().getValue();
    }

    public void printQ() {
        tree.displayTreeReversed();
        System.out.println();
    }

}
