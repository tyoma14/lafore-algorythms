package org.example.ch8;

import java.util.Objects;

/**
 * Двоичное дерево поиска
 * @param <K> - тип ключей для узлов
 * @param <V> - тип значений для узлов
 */
public class BinarySearchTree<K extends Comparable<K>, V> {

    private Node<K, V> root;

    public Node<K, V> find(K key) {
        Node<K, V> current = root;
        while (!Objects.equals(current.key, key)) {
            if (key.compareTo(current.key) < 0) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    public void insert(K key, V value) {
        Node<K, V> newNode = new Node<>();
        newNode.key = key;
        newNode.value = value;
        if (root == null) {
            root = newNode;
        } else {
            Node<K, V> current = root;
            Node<K, V> parent;
            while (true) {
                parent = current;
                if (key.compareTo(current.key) < 0) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    private void inOrder(Node<K, V> localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.leftChild);
            System.out.print(localRoot.key + " ");
            inOrder(localRoot.rightChild);
        }
    }

    public Node<K, V> minimum() {
        Node<K, V> current = root;
        Node<K, V> last = null;
        while (current != null) {
            last = current;
            current = current.leftChild;
        }
        return last;
    }

    /**
     * Ищет преемника для удаляемого узла.
     * Предполагается, что у удаляемого узла два потомка
     * @param delNode - удаляемый узел
     * @return узел-преемник
     */
    private Node<K, V> getSuccessor(Node<K, V> delNode) {
        Node<K, V> successorParent = delNode;
        Node<K, V> successor = delNode;
        Node<K, V> current = delNode.rightChild;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if (successor != delNode.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }

    public static class Node<K, V> {

        K key;
        V value;
        Node<K, V> leftChild;
        Node<K, V> rightChild;

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

}
