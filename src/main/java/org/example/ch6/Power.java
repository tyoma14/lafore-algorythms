package org.example.ch6;

public class Power {

    public static int power(int x, int y) {
        if (y == 1) {
            return x;
        }
        if (y % 2 != 0) {
            return x * power(x * x, y/2);
        }
        return power(x * x, y/2);
    }

}
