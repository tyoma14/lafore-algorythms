package org.example.ch4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Artyom Zheltyshev on 19.06.2024
 */
class CalcPostTest {

    @Test
    void doCalc() {
        CalcPost calcPost = new CalcPost("345+*612+/-");
        int result = calcPost.doCalc();
        assertEquals(25, result);
    }
}