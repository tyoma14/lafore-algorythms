package org.example.ch5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Artyom Zheltyshev on 30.06.2024
 */
class LinkListTest {

    @Test
    void insertAndDeleteFirst() {
        LinkList<Integer> theList = new LinkList<>();
        theList.insertFirst(22);
        theList.insertFirst(44);
        theList.insertFirst(66);
        theList.insertFirst(88);

        theList.displayList();

        while (!theList.isEmpty()) {
            Link<Integer> aLink = theList.deleteFirst();
            System.out.print("Deleted ");
            aLink.displayData();
            System.out.println();
        }

        theList.displayList();
    }

    @Test
    void findAndDelete() {
        LinkList<Integer> theList = new LinkList<>();
        theList.insertFirst(22);
        theList.insertFirst(44);
        theList.insertFirst(66);
        theList.insertFirst(88);

        theList.displayList();

        Link<Integer> f = theList.find(44);
        if (f != null) {
            System.out.println("Found link with key " + f.data);
        } else {
            System.out.println("Can`t find link");
        }

        Link<Integer> d = theList.delete(66);
        if (d != null) {
            System.out.println("Deleted link with key " + d.data);
        } else {
            System.out.println("Can`t delete link");
        }

        theList.displayList();
    }
}