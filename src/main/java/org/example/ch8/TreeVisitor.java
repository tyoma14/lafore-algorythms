package org.example.ch8;

/**
 * Посетитель элементов дерева Хаффмана
 * @param <R> - возвращаемый результат посещения
 */
public interface TreeVisitor<R> {

    R visit(HuffmanTree.Node node);

    R visit(HuffmanTree.Leaf leaf);

}
