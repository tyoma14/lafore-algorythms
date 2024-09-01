package org.example.ch6;

/**
 * Вычисление треугольных чисел
 */
public class TriangleNumber {

    public static int triangle(int n) {
        System.out.println("Entering: n=" + n);
        if (n == 1) {
            System.out.println("Returning 1");
            return 1;
        } else {
            int temp = n + triangle(n-1);
            System.out.println("Returning " + temp);
            return temp;
        }
    }

}
