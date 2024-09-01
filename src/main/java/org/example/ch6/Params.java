package org.example.ch6;

/**
 * Параметры, сохраняемые в стеке
 */
public class Params {

    public int n;
    public int returnAddress;

    public Params(int n, int returnAddress) {
        this.n = n;
        this.returnAddress = returnAddress;
    }
}
