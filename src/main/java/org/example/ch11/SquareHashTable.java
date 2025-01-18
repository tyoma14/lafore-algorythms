package org.example.ch11;

/**
 * Хеш-таблица с квадратичным пробированием
 */
public class SquareHashTable {

    private static final DataItem NON_ITEM = new DataItem(-1);
    private DataItem[] hashArray;
    private int arraySize;

    // Размер таблицы должен быть простым числом
    // В противном случае возникнет бесконечная последовательность проб
    public SquareHashTable(int arraySize) {
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

    public int hashFunc(int key) {
        return key % arraySize;
    }

    public void insert(DataItem item) {
        int key = item.getKey();
        int hashVal = hashFunc(key);
        int index = hashVal;
        for (int i = 1; hashArray[index] != null && hashArray[index].getKey() != -1; i++) {
            index = hashVal + i*i;
            index %= arraySize;
        }
        hashArray[index] = item;
    }

    public DataItem delete(int key) {
        int hashVal = hashFunc(key);
        int index = hashVal;
        for (int i = 1; hashArray[index] != null; i++) {
            if (hashArray[index].getKey() == key) {
                DataItem temp = hashArray[index];
                hashArray[index] = NON_ITEM;
                return temp;
            }
            index = hashVal + i*i;
            index %= arraySize;
        }
        return null;
    }

    public DataItem find(int key) {
        int hashVal = hashFunc(key);
        int index = hashVal;
        for (int i = 1; hashArray[index] != null; i++) {
            if (hashArray[index].getKey() == key) {
                return hashArray[index];
            }
            index = hashVal + i*i;
            index %= arraySize;
        }
        return null;
    }

}
