package org.example.ch12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeapTreeTest {

    @Test
    void test() {
        HeapTree heapTree = new HeapTree();

        heapTree.insert(70);
        heapTree.insert(40);
        heapTree.insert(50);
        heapTree.insert(20);
        heapTree.insert(60);
        heapTree.insert(100);
        heapTree.insert(80);
        heapTree.insert(30);
        heapTree.insert(10);
        heapTree.insert(90);

        assertEquals(100, heapTree.findByNum(1).getKey());
        assertEquals(90, heapTree.findByNum(2).getKey());
        assertEquals(80, heapTree.findByNum(3).getKey());
        assertEquals(30, heapTree.findByNum(4).getKey());
        assertEquals(60, heapTree.findByNum(5).getKey());
        assertEquals(40, heapTree.findByNum(10).getKey());

        assertEquals(100, heapTree.remove());
        assertEquals(90, heapTree.remove());
        assertEquals(80, heapTree.remove());
        assertEquals(70, heapTree.remove());

        HeapTree.Node inserted = heapTree.insert(53);
        HeapTree.Node changed = heapTree.change(inserted, 73);
        assertEquals(73, changed.getKey());
    }
}