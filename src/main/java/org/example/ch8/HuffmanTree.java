package org.example.ch8;

/**
 * Дерево Хаффмана
 */
public class HuffmanTree {

    private final Element root;

    public HuffmanTree(Element root) {
        this.root = root;
    }

    public Element getRoot() {
        return root;
    }

    public interface Element {

        <R> R accept(TreeVisitor<R> visitor);

        Integer getFrequency();

    }

    public static class Node implements Element {

        private final Element left;
        private final Element right;
        private final Integer frequency;

        public Node(Element left, Element right, Integer frequency) {
            this.left = left;
            this.right = right;
            this.frequency = frequency;
        }

        @Override
        public Integer getFrequency() {
            return frequency;
        }

        @Override
        public <R> R accept(TreeVisitor<R> visitor) {
            return visitor.visit(this);
        }

        public Element getLeft() {
            return left;
        }

        public Element getRight() {
            return right;
        }
    }

    public static class Leaf implements Element {

        private final Integer frequency;
        private final Character character;

        public Leaf(Integer frequency, Character character) {
            this.frequency = frequency;
            this.character = character;
        }

        @Override
        public <R> R accept(TreeVisitor<R> visitor) {
            return visitor.visit(this);
        }

        @Override
        public Integer getFrequency() {
            return frequency;
        }

        public Character getCharacter() {
            return character;
        }
    }

}
