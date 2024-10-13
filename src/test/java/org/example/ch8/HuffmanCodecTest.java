package org.example.ch8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HuffmanCodecTest {

    @Test
    void test() {
        String message = "SUSIE SAYS IT IS EASY";
        HuffmanCodec codec = HuffmanCodec.fromMessage(message);
        String encodedMessage = codec.encode(message);
        System.out.println(encodedMessage);
        assertEquals(message, codec.decode(encodedMessage));
    }
}