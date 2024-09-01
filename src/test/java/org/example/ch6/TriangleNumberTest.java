package org.example.ch6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TriangleNumberTest {

    @Test
    void triangle() {
        int result = TriangleNumber.triangle(5);
        Assertions.assertEquals(15, result);
    }

}