package org.example.ch10;

import java.lang.reflect.Array;
import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Дерево 2-3
 * @param <T>
 */
public class Tree23<T> {

    private static final int ORDER = 3;
    private Node root = new Node();
    private final Comparator<T> comparator;

    public Tree23(Comparator<T> comparator) {
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
            if (currNode.isLeaf()) {
                if (currNode.isFull()) {
                    split(currNode, item);
                } else {
                    currNode.insertItem(item);
                }
                break;
            } else {
                currNode = getNextChild(currNode, item);
            }
        }
    }

    private Node split(Node thisNode, T item) {
        T itemB = thisNode.removeItem();
        T itemA = thisNode.removeItem();
        Node newRight = new Node();

        T thisItem;    // остаётся в текущем узле
        T parentItem;  // уходит наверх и участвует в дальнейших разбиениях
        T rightItem;   // уходит в узел справа

        if (comparator.compare(item, itemA) < 0) {
            thisItem = item;
            parentItem = itemA;
            rightItem = itemB;
        } else if (comparator.compare(item, itemB) < 0) {
            thisItem = itemA;
            parentItem = item;
            rightItem = itemB;
        } else {
            thisItem = itemA;
            parentItem = itemB;
            rightItem = item;
        }

        thisNode.insertItem(thisItem);
        newRight.insertItem(rightItem);

        Node parent = thisNode.getParent();

        // если разбиваем корневой узел
        if (parent == null) {
            root = new Node();
            root.insertItem(parentItem);
            root.connectChild(0, thisNode);
            root.connectChild(1, newRight);
            return newRight;
        }

        if (parent.isFull()) {
            Node newRightParent = split(parent, parentItem);
            if (parent.getChild(0) == thisNode) {
                Node child1 = parent.disconnectChild(1);
                Node child2 = parent.disconnectChild(2);
                parent.connectChild(1, newRight);
                newRightParent.connectChild(0, child1);
                newRightParent.connectChild(1, child2);
            } else if (parent.getChild(1) == thisNode) {
                Node child2 = parent.disconnectChild(2);
                newRightParent.connectChild(0, newRight);
                newRightParent.connectChild(1, child2);
            } else if (parent.getChild(2) == thisNode) {
                Node child2 = parent.disconnectChild(2);
                newRightParent.connectChild(0, child2);
                newRightParent.connectChild(1, newRight);
            }
        } else {
            int itemIndex = parent.insertItem(parentItem);
            int n = parent.getNumItems();

            for (int j=n-1; j > itemIndex; j--) {
                Node temp = parent.disconnectChild(j);
                parent.connectChild(j+1, temp);
            }

            parent.connectChild(itemIndex + 1, newRight);
        }

        return newRight;
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

    private class Node {

        private int itemsNumber;
        @SuppressWarnings("unchecked")
        private T[] items = (T[]) new Object[ORDER - 1];
        @SuppressWarnings("unchecked")
        private Node[] children = (Node[]) Array.newInstance(Node.class, ORDER);
        private Node parent;

        public int findItem(T item) {
            for (int j = 0; j < ORDER - 1; j++) {
                if (items[j] == null) {
                    break;
                } else if (Objects.equals(items[j], item)) {
                    return j;
                }
            }
            return -1;
        }

        public int insertItem(T newItem) {
            itemsNumber++;
            for (int j = ORDER - 2; j >= 0; j--) {
                if (items[j] != null) {
                    if (comparator.compare(newItem, items[j]) < 0) {
                        items[j+1] = items[j];
                    } else {
                        items[j+1] = newItem;
                        return j+1;
                    }
                }
            }
            items[0] = newItem;
            return 0;
        }

        public void connectChild(int childNum, Node child) {
            children[childNum] = child;
            if (child != null) {
                child.parent = this;
            }
        }

        public Node disconnectChild(int childNum) {
            Node tempNode = children[childNum];
            children[childNum] = null;
            return tempNode;
        }

        public T removeItem() {
            T temp = items[itemsNumber - 1];
            items[itemsNumber - 1] = null;
            itemsNumber--;
            return temp;
        }

        public boolean isLeaf() {
            return children[0]==null;
        }

        public boolean isFull() {
            return itemsNumber == ORDER - 1;
        }

        public int getNumItems() {
            return itemsNumber;
        }

        public T getItem(int index) {
            return items[index];
        }

        public Node getChild(int childNum) {
            return children[childNum];
        }

        public Node getParent() {
            return parent;
        }

        public void displayNode() {
            String nodeStr = Stream.of(items)
                    .filter(Objects::nonNull)
                    .map(Objects::toString)
                    .collect(Collectors.joining("/", "/", "/"));
            System.out.println(nodeStr);
        }
    }

}
