package org.example.ch10;

import java.lang.reflect.Array;
import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Дерево 2-3-4
 * @param <T> - тип элементов
 */
public class Tree234<T> {

    private Node root = new Node();
    private final Comparator<T> comparator;

    public Tree234(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public int find(T item) {
        Node currNode = root;
        int childNumber;
        while (true) {
            if ((childNumber=currNode.findItem(item)) != -1) {
                return childNumber;
            } else if (currNode.isLeaf()) {
                return -1;
            } else {
                currNode = getNextChild(currNode, item);
            }
        }
    }

    public void insert(T item) {
        Node currNode = root;
        while (true) {
            if (currNode.isFull()) {
                split(currNode);
                currNode = currNode.getParent();
                currNode = getNextChild(currNode, item);
            } else if (currNode.isLeaf()) {
                break;
            } else {
                currNode = getNextChild(currNode, item);
            }
        }
        currNode.insertItem(item);
    }

    private void split(Node thisNode) {
        T itemB, itemC;
        Node parent, child2, child3;
        int itemIndex;

        itemC = thisNode.removeItem();
        itemB = thisNode.removeItem();
        child2 = thisNode.disconnectChild(2);
        child3 = thisNode.disconnectChild(3);
        Node newRight = new Node();

        if (thisNode == root) {
            root = new Node();
            parent = root;
            root.connectChild(0, thisNode);
        } else {
            parent = thisNode.getParent();
        }

        itemIndex = parent.insertItem(itemB);
        int n = parent.getNumItems();

        for (int j=n-1; j > itemIndex; j--) {
            Node temp = parent.disconnectChild(j);
            parent.connectChild(j+1, temp);
        }

        parent.connectChild(itemIndex + 1, newRight);

        newRight.insertItem(itemC);
        newRight.connectChild(0, child2);
        newRight.connectChild(1, child3);
    }

    private Node getNextChild(Node theNode, T theItem) {
        int j;
        int numItems = theNode.getNumItems();
        for (j=0; j<numItems; j++) {
            if (comparator.compare(theItem, theNode.getItem(j)) < 0) {
                return theNode.getChild(j);
            }
        }
        return theNode.getChild(j);
    }

    public void displayTree() {
        recDisplayTree(root, 0, 0);
    }

    private void recDisplayTree(Node thisNode, int level, int childNumber) {
        System.out.format("level=%s child=%s ", level, childNumber);
        thisNode.displayNode();

        int numItems = thisNode.getNumItems();
        for (int j = 0; j < numItems + 1; j++) {
            Node nextNode = thisNode.getChild(j);
            if (nextNode != null) {
                recDisplayTree(nextNode, level+1, j);
            } else {
                return;
            }
        }
    }

    public T getMin() {
        Node curr = root;
        Node next = curr.getChild(0);
        while (next != null) {
            curr = next;
            next = curr.getChild(0);
        }
        return curr.getItem(0);
    }

    public void traverse() {
        traverse(root);
    }

    private void traverse(Node curr) {
        if (curr.isLeaf()) {
            printData(curr);
        } else {
            int i;
            for (i=0; i < curr.getNumItems(); i++) {
                Node child = curr.getChild(i);
                traverse(child);

                T item = curr.getItem(i);
                System.out.print(" " + item);
            }
            Node lastChild = curr.getChild(i);
            traverse(lastChild);
        }
    }

    private void printData(Node curr) {
        for (int i = 0; i < curr.getNumItems(); i++) {
            System.out.print(" " + curr.getItem(i));
        }
    }

    private class Node {

        private static final int ORDER = 4;
        private int numItems;
        private Node parent;
        @SuppressWarnings("unchecked")
        private Node[] childArray = (Node[]) Array.newInstance(Node.class, ORDER);
        @SuppressWarnings("unchecked")
        private T[] itemArray = (T[]) new Object[ORDER - 1];

        public void connectChild(int childNum, Node child) {
            childArray[childNum] = child;
            if (child != null) {
                child.parent = this;
            }
        }

        public Node disconnectChild(int childNum) {
            Node tempNode = childArray[childNum];
            childArray[childNum] = null;
            return tempNode;
        }

        public Node getChild(int childNum) {
            return childArray[childNum];
        }

        public Node getParent() {
            return parent;
        }

        public boolean isLeaf() {
            return childArray[0]==null;
        }

        public int getNumItems() {
            return numItems;
        }

        public T getItem(int index) {
            return itemArray[index];
        }

        public boolean isFull() {
            return numItems == ORDER - 1;
        }

        public int findItem(T item) {
            for (int j = 0; j < ORDER - 1; j++) {
                if (itemArray[j] == null) {
                    break;
                } else if (Objects.equals(itemArray[j], item)) {
                    return j;
                }
            }
            return -1;
        }

        public int insertItem(T newItem) {
            numItems++;
            for (int j = ORDER - 2; j >= 0; j--) {
                if (itemArray[j] != null) {
                    if (comparator.compare(newItem, itemArray[j]) < 0) {
                        itemArray[j+1] = itemArray[j];
                    } else {
                        itemArray[j+1] = newItem;
                        return j+1;
                    }
                }
            }
            itemArray[0] = newItem;
            return 0;
        }

        public T removeItem() {
            T temp = itemArray[numItems - 1];
            itemArray[numItems - 1] = null;
            numItems--;
            return temp;
        }

        public void displayNode() {
            String nodeStr = Stream.of(itemArray)
                    .filter(Objects::nonNull)
                    .map(Objects::toString)
                    .collect(Collectors.joining("/", "/", "/"));
            System.out.println(nodeStr);
        }
    }

}
