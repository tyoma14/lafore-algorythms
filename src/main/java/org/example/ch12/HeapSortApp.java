package org.example.ch12;

/**
 * Пирамидальная сортировка
 */
public class HeapSortApp {

    public static void main(String[] args) {
        int size=10, j;
        Heap theHeap = new Heap(size);

        for (j = 0; j < size; j++) {
            int random = (int) (Math.random()*100);
            Node newNode = new Node(random);
            theHeap.insertAt(j, newNode);
            theHeap.incrementSize();
        }

        System.out.print("Random: ");
        theHeap.displayArray();

        for (j = size/2-1; j >= 0; j--) {
            theHeap.trickleDown(j);
        }

        System.out.print("Heap:    ");
        theHeap.displayArray();
        theHeap.displayHeap();

        for (j = size-1; j>=0 ; j--) {
            Node biggestNode = theHeap.remove();
            theHeap.insertAt(j, biggestNode);
        }
        System.out.print("Sorted: ");
        theHeap.displayArray();
    }

}
