package org.example.ch6;

import org.example.ch4.StackX;

/**
 * Моделирование рекурсивного метода (как это примерно происходит на уровне JVM)
 */
public class StackSimulationTriangle {

    static int theNumber;
    static int theAnswer;
    static StackX<Params> theStack;
    static int codePart;
    static Params theseParams;

    public static void recTriangle() {
        theStack = new StackX<>(10000);
        codePart = 1;
        while (step() == false) {}
    }

    private static boolean step() {
        switch (codePart) {
            // Исходный вызов
            case 1:
                theseParams = new Params(theNumber, 6);
                theStack.push(theseParams);
                codePart = 2;
                break;
            // Вход в метод
            case 2:
                theseParams = theStack.peek();
                if (theseParams.n == 1) {  // Проверка
                    theAnswer = 1;
                    codePart = 5;          // Выход
                } else {
                    codePart = 3;          // Рекурсивный вызов
                }
                break;
            // Вызов метода
            case 3:
                Params newParams = new Params(theseParams.n - 1, 4);
                theStack.push(newParams);
                codePart = 2;  // Вход в метод
                break;
            // Вычисление
            case 4:
                theseParams = theStack.peek();
                theAnswer = theAnswer + theseParams.n;
                codePart = 5;
                break;
            // Выход из метода
            case 5:
                theseParams = theStack.peek();
                codePart = theseParams.returnAddress;
                theStack.pop();
                break;
            // Точка возврата
            case 6:
                return true;
        }
        return false;
    }

}
