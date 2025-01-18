package org.example.ch11;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeHashTableTest {

    @Test
    void test() {
        TreeHashTable hashTable = new TreeHashTable(5);
        hashTable.insert(new DataItem(20));

        // дерево в индексе 1
        hashTable.insert(new DataItem(6));
        hashTable.insert(new DataItem(1));
        hashTable.insert(new DataItem(11));
        hashTable.insert(new DataItem(16));

        hashTable.insert(new DataItem(2));
        hashTable.insert(new DataItem(8));
        hashTable.insert(new DataItem(14));

        System.out.println("Хеш-таблица: ");
        hashTable.displayTable();

        DataItem found = hashTable.find(11);
        System.out.println("Элемент с ключом 11: " + found);
    }
}