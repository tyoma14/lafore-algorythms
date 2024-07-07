package org.example.ch5;

/**
 * Created by Artyom Zheltyshev on 30.06.2024
 * Ссылка на элемент в списке
 */
public class Link<T> {

    public T data;
    public Link<T> next;

    public Link(T data) {
        this.data = data;
    }

    public void displayData() {
        System.out.print(data);
    }
}
