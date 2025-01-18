package org.example.ch11;

import java.util.Objects;

/**
 * Хеш-таблица для строк с линейным пробированием и хешированием с помощью полинома
 */
public class StringHashTable {

    private static final StringDataItem NON_ITEM = new StringDataItem("");
    private StringDataItem[] hashArray;
    private int arraySize;

    public StringHashTable(int arraySize) {
        this.arraySize = arraySize;
        hashArray = new StringDataItem[arraySize];
    }

    public void displayTable() {
        System.out.print("Table: ");
        for (int j = 0; j < arraySize; j++) {
            if (hashArray[j] != null) {
                System.out.print(hashArray[j].getKey() + " ");
            } else {
                System.out.print("** ");
            }
        }
        System.out.println();
    }

    public int hashFunc(String key) {
        int hashVal = 0;
        for (int j = 0; j < key.length(); j++) {
            int letter = key.charAt(j) - 96;
            hashVal = (hashVal * 27 + letter) % arraySize;
        }
        return hashVal;
    }

    public void insert(StringDataItem item) {
        String key = item.getKey();
        int hashVal = hashFunc(key);

        while (hashArray[hashVal] != null && !hashArray[hashVal].getKey().equals(NON_ITEM.getKey())) {
            ++hashVal;
            hashVal %= arraySize;
        }
        hashArray[hashVal] = item;
    }

    public StringDataItem delete(String key) {
        int hashVal = hashFunc(key);

        while (hashArray[hashVal] != null) {
            if (Objects.equals(hashArray[hashVal].getKey(), key)) {
                StringDataItem temp = hashArray[hashVal];
                hashArray[hashVal] = NON_ITEM;
                return temp;
            }
            ++hashVal;
            hashVal %= arraySize;
        }
        return null;
    }

    public StringDataItem find(String key) {
        int hashVal = hashFunc(key);

        while (hashArray[hashVal] != null) {
            if (Objects.equals(hashArray[hashVal].getKey(), key)) {
                return hashArray[hashVal];
            }
            ++hashVal;
            hashVal %= arraySize;
        }
        return null;
    }

}
