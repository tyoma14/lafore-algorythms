package org.example.ch11;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareHashTableTest {

    @Test
    void test() {
        DataItem aDataItem;
        int aKey;
        int size = 13;
        int n = 8;
        int keysPerCell = 10;

        SquareHashTable theHashTable = new SquareHashTable(size);

        for (int j = 0; j < n; j++) {
            aKey = (int) (Math.random() * keysPerCell * size);
            aDataItem = new DataItem(aKey);
            theHashTable.insert(aDataItem);
        }

        System.out.println("Initial table:");
        theHashTable.displayTable();

        System.out.println("Found " + theHashTable.find(66));

        theHashTable.insert(new DataItem(100));
        System.out.println("Table after 100 inserted:");
        theHashTable.displayTable();

        theHashTable.delete(100);
        System.out.println("Table after 100 removed:");
        theHashTable.displayTable();
    }
}