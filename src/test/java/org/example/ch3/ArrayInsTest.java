package org.example.ch3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Artyom Zheltyshev on 13.06.2024
 */
class ArrayInsTest {

    @Test
    void insertionSort() {
        ArrayIns arraySel = new ArrayIns(5);
        arraySel.insert(5);
        arraySel.insert(3);
        arraySel.insert(2);
        arraySel.insert(4);
        arraySel.insert(1);
        arraySel.insertionSort();
        arraySel.print();
    }
}