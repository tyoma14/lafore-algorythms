package org.example.ch6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackImplTriangleTest {

    @Test
    void stackTriangle() {
        StackImplTriangle.theNumber = 100;
        StackImplTriangle.stackTriangle();
        assertEquals(5050, StackImplTriangle.theAnswer);
    }

}