package org.example.ch11;

import org.example.ch8.BinarySearchTree;

/**
 * Хеш-таблица с разрешением коллизий с помощью дерева двоичного поиска
 */
public class TreeHashTable {

    private BinarySearchTree<Integer, DataItem>[] hashArray;
    private int arraySize;

    public TreeHashTable(int arraySize) {
        this.arraySize = arraySize;
        hashArray = new BinarySearchTree[arraySize];
        for (int j = 0; j < arraySize; j++) {
            hashArray[j] = new BinarySearchTree<>();
        }
    }

    public void displayTable() {
        for (int j = 0; j < arraySize; j++) {
            System.out.print(j + ". ");
            hashArray[j].displayTree();
            System.out.println();
        }
    }

    public int hashFunc(int key) {
        return key % arraySize;
    }

    public void insert(DataItem item) {
        int key = item.getKey();
        int hashVal = hashFunc(key);
        hashArray[hashVal].insert(key, item);
    }

    public DataItem find(int key) {
        int hashVal = hashFunc(key);
        BinarySearchTree.Node<Integer, DataItem> node = hashArray[hashVal].find(key);
        return node != null ? node.getValue() : null;
    }

}
