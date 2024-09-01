package org.example.ch6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnagramTest {

    @Test
    void doAnagram() {
        Anagram anagram = new Anagram("cats");
        anagram.doAnagram();
    }

}