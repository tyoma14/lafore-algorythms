package org.example.ch6;

import org.example.ch4.StackX;

/**
 * Реализация рекурсивного алгоритма с помощью стека
 */
public class StackImplTriangle {

    static int theNumber;
    static int theAnswer;
    static StackX<Integer> theStack;

    public static void stackTriangle() {
        theStack = new StackX<>(10000);
        theAnswer = 0;
        while (theNumber > 0) {
            theStack.push(theNumber);
            --theNumber;
        }
        while (!theStack.isEmpty()) {
            Integer newN = theStack.pop();
            theAnswer += newN;
        }
    }

}
