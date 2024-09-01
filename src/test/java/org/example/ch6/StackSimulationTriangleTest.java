package org.example.ch6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackSimulationTriangleTest {

    @Test
    void recTriangle() {
        StackSimulationTriangle.theNumber = 100;
        StackSimulationTriangle.recTriangle();
        assertEquals(StackSimulationTriangle.theAnswer, 5050);
    }

}