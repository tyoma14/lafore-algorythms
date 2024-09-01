package org.example.ch6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HanoiTowerTest {

    @Test
    void doTower() {
        HanoiTower.doTower(2, 'A', 'B', 'C');
    }
}