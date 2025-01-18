package org.example.ch11;

import org.junit.jupiter.api.Test;

class ExpandableHashTableTest {

    @Test
    void test() {
        ExpandableHashTable hashTable = new ExpandableHashTable(5);
        hashTable.insert(new DataItem(3));
        hashTable.insert(new DataItem(8));

        System.out.print("Hash table before expansion: ");
        hashTable.displayTable();

        hashTable.insert(new DataItem(1));
        hashTable.insert(new DataItem(11));
        hashTable.insert(new DataItem(28));

        System.out.print("Hash table after expansion: ");
        hashTable.displayTable();

        DataItem foundItem = hashTable.find(8);
        System.out.println("Found item with key 8: " + foundItem);
    }
}