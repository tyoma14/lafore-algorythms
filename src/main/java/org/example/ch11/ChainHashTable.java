package org.example.ch11;

/**
 * Хеш-таблица с использованием метода цепочек
 * на базе упорядоченного связного списка
 */
public class ChainHashTable {

    private SortedList[] hashArray;
    private int arraySize;

    public ChainHashTable(int arraySize) {
        this.arraySize = arraySize;
        hashArray = new SortedList[arraySize];
        for (int j = 0; j < arraySize; j++) {
            hashArray[j] = new SortedList();
        }
    }

    public void displayTable() {
        for (int j = 0; j < arraySize; j++) {
            System.out.print(j + ". ");
            hashArray[j].displayList();
        }
    }

    public int hashFunc(int key) {
        return key % arraySize;
    }

    public void insert(Link theLink) {
        int key = theLink.getKey();
        int hashVal = hashFunc(key);
        hashArray[hashVal].insert(theLink);
    }

    public void delete(int key) {
        int hashVal = hashFunc(key);
        hashArray[hashVal].delete(key);
    }

    public Link find(int key) {
        int hashVal = hashFunc(key);
        return hashArray[hashVal].find(key);
    }

    public static class SortedList {

        private Link first;

        public SortedList() {
            first = null;
        }

        public void insert(Link theLink) {
            int key = theLink.getKey();
            Link previous = null;
            Link current = first;

            while (current != null && key > current.getKey()) {
                previous = current;
                current = current.next;
            }
            if (previous == null) {
                first = theLink;
            } else {
                previous.next = theLink;
            }
            theLink.next = current;
        }

        public void delete(int key) {
            Link previous = null;
            Link current = first;

            while (current != null && key != current.getKey()) {
                previous = current;
                current = current.next;
            }
            if (previous == null) {
                assert first != null;
                first = first.next;
            } else {
                assert current != null;
                previous.next = current.next;
            }
        }

        public Link find(int key) {
            Link current = first;
            while (current != null && current.getKey() <= key) {
                if (current.getKey() == key) {
                    return current;
                }
                current = current.next;
            }
            return null;
        }

        public void displayList() {
            System.out.print("List (first-->last): ");
            Link current = first;
            while (current != null) {
                current.displayLink();
                current = current.next;
            }
            System.out.println();
        }
    }

    public static class Link {

        private int iData;
        public Link next;

        public Link(int iData) {
            this.iData = iData;
        }

        public int getKey() {
            return iData;
        }

        public void displayLink() {
            System.out.print(iData + " ");
        }
    }

}
