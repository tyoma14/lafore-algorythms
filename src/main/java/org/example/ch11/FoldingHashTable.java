package org.example.ch11;

import java.util.Objects;

/**
 * Хеш-таблица для строк с линейным пробированием и хешированием по методу свёртки
 */
public class FoldingHashTable {

    private static final StringDataItem NON_ITEM = new StringDataItem("");
    private StringDataItem[] hashArray;
    private int arraySize;
    private int groupSize;

    public FoldingHashTable(int arraySize) {
        this.arraySize = arraySize;
        hashArray = new StringDataItem[arraySize];
        groupSize = (int) Math.log10(arraySize);
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
        String digits = "";
        for (int j = 0; j < key.length(); j++) {
            int charCode = key.charAt(j) - 96;
            digits = digits.concat(Integer.toString(charCode));
        }

        int hashVal = 0;
        for (int j = 0; j < digits.length(); j+=groupSize) {
            int endIndex;
            if (digits.length()-j < groupSize) {
                endIndex = digits.length();
            } else {
                endIndex = j+groupSize;
            }
            String group = digits.substring(j, endIndex);
            int num = Integer.parseInt(group);
            hashVal += num;
        }
        hashVal = hashVal % arraySize;
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
