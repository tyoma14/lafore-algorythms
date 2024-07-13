package org.example.ch5;

import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Artyom Zheltyshev on 13.07.2024
 */
class LinkedMatrixTest {

    @Test
    void test() {
        BiFunction<Integer, Integer, String> initialValue = (i, j) -> "" + i + j;
        LinkedMatrix<String> linkedMatrix = new LinkedMatrix<>(4, 3, initialValue);
        linkedMatrix.print();

        linkedMatrix.insert(2, 3, "ins");
        linkedMatrix.print();
    }

}