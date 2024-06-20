package org.example.ch4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Artyom Zheltyshev on 19.06.2024
 */
class InToPostTest {

    @Test
    void doTrans() {
        InToPost inToPost = new InToPost("A*(B+C)-D/(E+F)");
        String output = inToPost.doTrans();
        Assertions.assertEquals("ABC+*DEF+/-", output);
    }
}