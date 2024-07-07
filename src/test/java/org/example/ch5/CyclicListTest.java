package org.example.ch5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Artyom Zheltyshev on 06.07.2024
 */
class CyclicListTest {

    @Test
    void test() {
        CyclicList<Integer> cyclicList = new CyclicList<>();
        cyclicList.insert(1);
        cyclicList.insert(2);
        cyclicList.insert(3);
        cyclicList.insert(4);
        cyclicList.insert(5);

        cyclicList.display();

        Link<Integer> foundLink = cyclicList.find(4);
        assertEquals(4, foundLink.data);

        cyclicList.delete(4);
        cyclicList.display();
    }
}