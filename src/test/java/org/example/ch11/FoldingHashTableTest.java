package org.example.ch11;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FoldingHashTableTest {

    @Test
    void test() {
        FoldingHashTable theHashTable = new FoldingHashTable(111);

        theHashTable.insert(new StringDataItem("cat"));
        theHashTable.insert(new StringDataItem("book"));
        theHashTable.insert(new StringDataItem("door"));
        theHashTable.insert(new StringDataItem("table"));
        theHashTable.insert(new StringDataItem("cup"));
        theHashTable.insert(new StringDataItem("chair"));
        theHashTable.insert(new StringDataItem("floor"));
        theHashTable.insert(new StringDataItem("mouse"));

        System.out.println("Initial table:");
        theHashTable.displayTable();

        System.out.println("Found " + theHashTable.find("cup"));

        theHashTable.insert(new StringDataItem("lamp"));
        System.out.println("Table after `lamp` inserted:");
        theHashTable.displayTable();

        theHashTable.delete("lamp");
        System.out.println("Table after `lamp` removed:");
        theHashTable.displayTable();
    }

}