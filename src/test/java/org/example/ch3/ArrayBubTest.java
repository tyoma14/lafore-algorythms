package org.example.ch3;

import org.example.ch3.ArrayBub;
import org.junit.jupiter.api.Test;

/**
 * Created by Artyom Zheltyshev on 13.06.2024
 */
class ArrayBubTest {

    @Test
    void bubbleSort() {
        ArrayBub arrayBub = new ArrayBub(5);
        arrayBub.insert(5);
        arrayBub.insert(3);
        arrayBub.insert(2);
        arrayBub.insert(4);
        arrayBub.insert(1);
        arrayBub.bubbleSort();
        arrayBub.print();
    }

    @Test
    void doubleSidedBubbleSort() {
        ArrayBub arrayBub = new ArrayBub(6);
        arrayBub.insert(5);
        arrayBub.insert(3);
        arrayBub.insert(2);
        arrayBub.insert(6);
        arrayBub.insert(4);
        arrayBub.insert(1);
        arrayBub.doubleSidedBubbleSort();
        arrayBub.print();
    }
}