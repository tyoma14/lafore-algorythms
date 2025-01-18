package org.example.ch11;

import org.junit.jupiter.api.Test;

import static org.example.ch11.ChainHashTable.*;

class ChainHashTableTest {

    @Test
    void test() {
        int aKey;
        Link aDataItem;
        int size = 20;
        int n = 20;
        int keysPerCell = 100;

        ChainHashTable theHashTable = new ChainHashTable(size);

        for (int j = 0; j < n; j++) {
            aKey = (int)(Math.random() * keysPerCell * size);
            aDataItem = new Link(aKey);
            theHashTable.insert(aDataItem);
        }

        theHashTable.displayTable();
    }

}