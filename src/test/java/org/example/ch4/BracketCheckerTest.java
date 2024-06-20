package org.example.ch4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Artyom Zheltyshev on 18.06.2024
 */
class BracketCheckerTest {

    @Test
    void check() {
        BracketChecker bracketChecker = new BracketChecker("a{b((c))d}e");
        bracketChecker.check();
    }
}