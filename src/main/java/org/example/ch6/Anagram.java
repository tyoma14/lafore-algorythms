package org.example.ch6;

/**
 * Вывод всех анаграмм для указанного слова
 */
public class Anagram {

    private int count;
    private int size;
    private final char[] arrChar = new char[100];

    public Anagram(String word) {
        size = word.length();
        count = 0;
        for (int j=0; j<size; j++) {
            arrChar[j] = word.charAt(j);
        }
    }

    public void doAnagram() {
        doAnagram(size);
    }

    public void doAnagram(int newSize) {
        if (newSize == 1) {
            return;
        }
        for (int j=0; j<newSize; j++) {
            doAnagram(newSize - 1);
            if (newSize == 2) {
                displayWord();
            }
            rotate(newSize);
        }
    }

    private void rotate(int newSize) {
        int j;
        int position = size - newSize;
        char temp = arrChar[position];
        for (j=position+1; j<size; j++) {
            arrChar[j-1] = arrChar[j];
        }
        arrChar[j-1] = temp;
    }

    private void displayWord() {
        if (count < 99) {
            System.out.print(" ");
        }
        if (count < 9) {
            System.out.print(" ");
        }
        System.out.print(++count + " ");
        for (int j=0; j<size; j++) {
            System.out.print(arrChar[j]);
        }
        System.out.print("  ");
        System.out.flush();
        if (count % 6 == 0) {
            System.out.println();
        }
    }

}
