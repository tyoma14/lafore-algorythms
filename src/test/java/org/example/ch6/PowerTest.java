package org.example.ch6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PowerTest {

    @Test
    void evenPower() {
        int result = Power.power(2, 8);
        assertEquals(256, result);
    }

    @Test
    void oddPower() {
        int result = Power.power(3, 18);
        assertEquals(387420489, result);
    }
}