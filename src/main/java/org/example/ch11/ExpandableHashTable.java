package org.example.ch11;

/**
 * Расширяемая хеш-таблица с линейным пробированием
 */
public class ExpandableHashTable {

    private static final DataItem NON_ITEM = new DataItem(-1);
    private DataItem[] hashArray;
    private int arraySize;
    private int itemsCount = 0;

    // должно быть простым положительным числом
    public ExpandableHashTable(int initialCapacity) {
        this.arraySize = initialCapacity;
        hashArray = new DataItem[initialCapacity];
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

    public int hashFunc(int key) {
        return key % arraySize;
    }

    public void insert(DataItem item) {
        if (loadFactor() > 0.5) {
            rehash();
        }

        int key = item.getKey();
        int hashVal = hashFunc(key);

        while (hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1) {
            ++hashVal;
            hashVal %= arraySize;
        }
        hashArray[hashVal] = item;
        itemsCount++;
    }

    private double loadFactor() {
        return (double) itemsCount / (double) arraySize;
    }

    private void rehash() {
        DataItem[] oldArray = hashArray;
        arraySize = getPrime(arraySize * 2);
        hashArray = new DataItem[arraySize];
        itemsCount = 0;
        for (DataItem item : oldArray) {
            if (item != null && item.getKey() != -1) {
                insert(item);
            }
        }
    }

    private int getPrime(int min) {
        int j = min + 1;
        return isPrime(j) ? j : getPrime(j);
    }

    private boolean isPrime(int n) {
        for (int j = 2; j*j <= n; j++) {
            if (n % j == 0) {
                return false;
            }
        }
        return true;
    }

    public DataItem delete(int key) {
        int hashVal = hashFunc(key);

        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                DataItem temp = hashArray[hashVal];
                hashArray[hashVal] = NON_ITEM;
                itemsCount--;
                return temp;
            }
            ++hashVal;
            hashVal %= arraySize;
        }
        return null;
    }

    public DataItem find(int key) {
        int hashVal = hashFunc(key);

        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                return hashArray[hashVal];
            }
            ++hashVal;
            hashVal %= arraySize;
        }
        return null;
    }

}
