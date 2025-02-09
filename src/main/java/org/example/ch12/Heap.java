package org.example.ch12;

import java.util.Comparator;

/**
 * Пирамида на базе массива
 */
public class Heap {

    private Node[] heapArray;
    private int maxSize;
    private int currentSize;
    private Comparator<Integer> comparator = naturalOrder().reversed();

    private Comparator<Integer> naturalOrder() {
        return Comparator.naturalOrder();
    }

    public Heap(int maxSize) {
        this.maxSize = maxSize;
        currentSize = 0;
        heapArray = new Node[maxSize];
    }

    public Heap(int maxSize, Comparator<Integer> comparator) {
        this.maxSize = maxSize;
        currentSize = 0;
        heapArray = new Node[maxSize];
        this.comparator = comparator;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean insert(int key) {
        if (currentSize == maxSize) {
            return false;
        }
        Node newNode = new Node(key);
        heapArray[currentSize] = newNode;
        trickleUp(currentSize++);
        return true;
    }

    public void trickleUp(int index) {
        int parent = (index-1) / 2;
        Node bottom = heapArray[index];
        while (index > 0 && comparator.compare(heapArray[parent].getKey(), bottom.getKey()) > 0) {
            heapArray[index] = heapArray[parent];
            index = parent;
            parent = (parent-1) / 2;
        }
        heapArray[index] = bottom;
    }

    public Node remove() {
        Node root = heapArray[0];
        heapArray[0] = heapArray[--currentSize];
        trickleDown(0);
        return root;
    }

    public void trickleDown(int index) {
        int largerChild;
        Node top = heapArray[index];
        while (index < currentSize / 2) {
            int leftChild = 2 * index + 1;
            int rightChild = leftChild + 1;

            if (rightChild < currentSize &&
                comparator.compare(heapArray[leftChild].getKey(), heapArray[rightChild].getKey()) > 0) {

                largerChild = rightChild;
            } else {
                largerChild = leftChild;
            }

            if (comparator.compare(top.getKey(), heapArray[largerChild].getKey()) <= 0) {
                break;
            }

            heapArray[index] = heapArray[largerChild];
            index = largerChild;
        }
        heapArray[index] = top;
    }

//    public boolean change(int index, int newValue) {
//        if (index<0 || index>=currentSize) {
//            return false;
//        }
//        int oldValue = heapArray[index].getKey();
//        heapArray[index].setKey(newValue);
//
//        if (oldValue < newValue) {
//            trickleUp(index);
//        } else {
//            trickleDown(index);
//        }
//        return true;
//    }

    public void displayHeap() {
        System.out.print("heapArray: ");
        for (int m = 0; m < currentSize; m++) {
            if (heapArray[m] != null) {
                System.out.print(heapArray[m].getKey() + " ");
            } else {
                System.out.print("--");
            }
        }
        System.out.println();

        int nBlanks = 32;
        int itemsPerRow = 1;
        int column = 0;
        int j = 0;
        String dots = "...............................";
        System.out.println(dots+dots);

        while (currentSize > 0) {
            if (column == 0) {
                for (int k = 0; k < nBlanks; k++) {
                    System.out.print(' ');
                }
            }
            System.out.print(heapArray[j].getKey());
            if (++j == currentSize) {
                break;
            }

            if (++column == itemsPerRow) {
                nBlanks /= 2;
                itemsPerRow *= 2;
                column = 0;
                System.out.println();
            } else {
                for (int k = 0; k < nBlanks * 2 - 2; k++) {
                    System.out.print(' ');
                }
            }
        }

        System.out.println("\n" + dots + dots);
    }

    public void displayArray() {
        for (int j = 0; j < maxSize; j++) {
            System.out.print(heapArray[j].getKey() + " ");
        }
        System.out.println();
    }

    public void insertAt(int index, Node newNode) {
        heapArray[index] = newNode;
    }

    public void incrementSize() {
        currentSize++;
    }

    public void insertAll(int... keys) {
        for (int key: keys) {
            toss(key);
        }
        if (keys.length > 0) {
            restoreHeap();
        }
    }

    private void toss(int key) {
        Node newNode = new Node(key);
        heapArray[currentSize] = newNode;
        currentSize++;
    }

    private void restoreHeap() {
        for (int j = currentSize/2-1; j >= 0; j--) {
            trickleDown(j);
        }
    }
}
