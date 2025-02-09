package org.example.ch12;

/**
 * Пирамидальное дерево
 */
public class HeapTree {

    private Node root;
    private int count;

    public Node insert(int key) {
        Node newNode = new Node(key);
        Node retVal;
        if (root == null) {
            root = newNode;
            retVal = newNode;
        } else {
            Node parent = root;
            int n = count + 1;
            String bits = bitsOf(n);
            int i = bits.length() - 2;
            for (; i > 0; i--) {
                if (bits.charAt(i) == '0') {
                    parent = parent.left;
                } else {
                    parent = parent.right;
                }
            }
            if (bits.charAt(i) == '0') {
                parent.attachLeft(newNode);
            } else {
                parent.attachRight(newNode);
            }
            retVal = trickleUp(newNode);
        }
        count++;
        check();
        return retVal;
    }

    private String bitsOf(int n) {
        String bits = "";
        while (n >= 1) {
            bits = bits.concat(String.valueOf((n % 2)));
            n /= 2;
        }
        return bits;
    }

    private Node trickleUp(Node node) {
        Node parent = node.parent;
        int bottomKey = node.getKey();
        Node currNode = node;
        while (parent != null && parent.getKey() < bottomKey) {
            currNode.setKey(parent.getKey());
            currNode = parent;
            parent = parent.parent;
        }
        currNode.setKey(bottomKey);
        return currNode;
    }

    public int remove() {
        int result = root.getKey();
        if (count == 1) {
            root = null;
        } else {
            Node last = root;
            String bits = bitsOf(count);
            int i = bits.length() - 2;
            for (; i >= 0; i--) {
                if (bits.charAt(i) == '0') {
                    last = last.left;
                } else {
                    last = last.right;
                }
            }
            last.detach();
            root.setKey(last.getKey());
            trickleDown(root);
        }
        count--;
        check();
        return result;
    }

    private Node trickleDown(Node top) {
        Node largerChild;
        Node currNode = top;
        int topKey = top.getKey();
        while (currNode.left != null) {
            Node left = currNode.left;
            Node right = currNode.right;

            if (right != null && left.getKey() < right.getKey()) {
                largerChild = right;
            } else {
                largerChild = left;
            }

            if (topKey >= largerChild.getKey()) {
                break;
            }

            currNode.setKey(largerChild.getKey());
            currNode = largerChild;
        }
        currNode.setKey(topKey);
        return currNode;
    }

    private void check() {
        check(root);
    }

    private void check(Node node) {
        Node left = node.left;
        if (left != null) {
            assert node.getKey() > left.getKey() : "Parent " + node.getKey() + " later than left child " + left.getKey();
            check(left);
        }

        Node right = node.right;
        if (right !=null) {
            assert node.getKey() > right.getKey() : "Parent " + node.getKey() + " later than right child " + right.getKey();
            check(right);
        }
    }

    public Node change(Node node, int newValue) {
        int oldValue = node.getKey();
        node.setKey(newValue);
        Node retVal;
        if (oldValue < newValue) {
            retVal = trickleUp(node);
        } else {
            retVal = trickleDown(node);
        }
        check();
        return retVal;
    }

    public static class Node {

        private Node parent;
        private Node left;
        private Node right;
        private int iData;

        public Node(int iData) {
            this.iData = iData;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public void attachLeft(Node left) {
            this.left = left;
            if (left != null) {
                left.parent = this;
            }
        }

        public void attachRight(Node right) {
            this.right = right;
            if (right != null) {
                right.parent = this;
            }
        }

        public void detach() {
            if (parent.left == this) {
                parent.left = null;
            } else if (parent.right == this) {
                parent.right = null;
            }
            this.parent = null;
        }

        public void setKey(int iData) {
            this.iData = iData;
        }

        public Node getParent() {
            return parent;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public int getKey() {
            return iData;
        }
    }

}
