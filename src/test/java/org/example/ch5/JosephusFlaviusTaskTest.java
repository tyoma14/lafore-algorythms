package org.example.ch5;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Artyom Zheltyshev on 07.07.2024
 */
class JosephusFlaviusTaskTest {

    @Test
    void killedPeopleNums() {
        JosephusFlaviusTask flaviusTask = new JosephusFlaviusTask(7, 3);
        List<Integer> killedPeopleNums = flaviusTask.killedPeopleNums();
        assertEquals(List.of(4, 1, 6, 5, 7, 3), killedPeopleNums);
    }

}