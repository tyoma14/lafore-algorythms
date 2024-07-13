package org.example.ch5;

import java.util.function.BiFunction;

/**
 * Created by Artyom Zheltyshev on 13.07.2024
 * Связная матрица
 */
public class LinkedMatrix<T> {

    private Node topLeft;
    private int width;
    private int height;

    public LinkedMatrix(int width, int height, BiFunction<Integer, Integer, T> initialValue) {
        this.width = width;
        this.height = height;

        Node prevRowStart = null;
        for (int i = 0; i < height; i++) {
            Node firstNodeInRow = null;
            Node top = null;
            Node left = null;
            for (int j = 0; j < width; j++) {
                Node newNode = new Node(initialValue.apply(i, j), null, null);

                if (i == 0 && j == 0) {
                    topLeft = newNode;
                }

                if (left != null) {
                    left.right = newNode;
                }
                left = newNode;

                if (j == 0) {
                    top = prevRowStart;
                }
                if (top != null) {
                    top.bottom = newNode;
                    top = top.right;
                }

                if (j == 0) {
                    firstNodeInRow = newNode;
                }
            }
            prevRowStart = firstNodeInRow;
        }
    }

    public void insert(int row, int col, T element) {
        if (row >= height || col >= width) {
            throw new IllegalArgumentException("Matrix index out of bounds");
        }
        Node curr = topLeft;
        for (int i = 0; i < row; i++) {
            curr = curr.bottom;
        }
        for (int j = 0; j < col; j++) {
            curr = curr.right;
        }
        curr.data = element;
    }

    public void print() {
        Node left = topLeft;
        while (left != null) {
            Node curr = left;
            while (curr != null) {
                System.out.print(curr.data + " ");
                curr = curr.right;
            }
            System.out.println();
            left = left.bottom;
        }
    }

    private class Node {

        private T data;
        private Node right;
        private Node bottom;

        public Node(T data, Node right, Node bottom) {
            this.data = data;
            this.right = right;
            this.bottom = bottom;
        }
    }


}
