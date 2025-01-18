package org.example.ch11;

/**
 * Хеш-таблица с двойным хешированием
 * Таблица нерасширяемая и работает корректно только будучи незаполненной
 */
public class DoubleHashTable {

    private static final DataItem NON_ITEM = new DataItem(-1);
    private DataItem[] hashArray;
    private int arraySize;

    // Размер массива должен быть простым по отношению к 5, 4, 3 и 2
    public DoubleHashTable(int arraySize) {
        this.arraySize = arraySize;
        hashArray = new DataItem[arraySize];
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

    public int hashFunc1(int key) {
        return key % arraySize;
    }

    // Возвращаемое значение отлично от нуля, меньше размера массива,
    // функция отлична от хеш-функции 1
    public int hashFunc2(int key) {
        return 5 - key % 5;
    }

    public void insert(int key, DataItem item) {
        int hashVal = hashFunc1(key);
        int stepSize = hashFunc2(key);

        while (hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1) {
            hashVal += stepSize;
            hashVal %= arraySize;
        }
        hashArray[hashVal] = item;
    }

    public DataItem delete(int key) {
        int hashVal = hashFunc1(key);
        int stepSize = hashFunc2(key);

        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                DataItem temp = hashArray[hashVal];
                hashArray[hashVal] = NON_ITEM;
                return temp;
            }
            hashVal += stepSize;
            hashVal %= arraySize;
        }
        return null;
    }

    public DataItem find(int key) {
        int hashVal = hashFunc1(key);
        int stepSize = hashFunc2(key);

        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                return hashArray[hashVal];
            }
            hashVal += stepSize;
            hashVal %= arraySize;
        }
        return null;
    }
}
