package org.example.ch8;

/**
 * Посетитель дерева для декодирования сообщения
 */
public class DecodingVisitor implements TreeVisitor<StringBuilder> {

    private final String bits;
    private int position = 0;
    private final StringBuilder result = new StringBuilder();
    private final HuffmanTree.Element root;

    public DecodingVisitor(String bits, HuffmanTree.Element root) {
        this.bits = bits;
        this.root = root;
    }

    @Override
    public StringBuilder visit(HuffmanTree.Node node) {
        if (position == bits.length()) {
            throw new IllegalStateException("Wrong bit sequence");
        }
        char bit = bits.charAt(position);
        HuffmanTree.Element nextElement;
        if (bit == '0') {
            nextElement = node.getLeft();
        } else {
            nextElement = node.getRight();
        }
        position++;

        if (nextElement != null) {
            nextElement.accept(this);
        }
        return result;
    }

    @Override
    public StringBuilder visit(HuffmanTree.Leaf leaf) {
        result.append(leaf.getCharacter());
        if (position < bits.length()) {
            root.accept(this);
        }
        return result;
    }

}
