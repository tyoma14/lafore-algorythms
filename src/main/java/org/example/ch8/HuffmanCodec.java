package org.example.ch8;

import org.example.ch4.PriorityQ;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Кодирование / декодирование по Хаффману
 */
public class HuffmanCodec {

    private final HuffmanTree tree;

    private HuffmanCodec(HuffmanTree tree) {
        this.tree = tree;
    }

    public String encode(String message) {
        // построение таблицы кодов
        CodeTableVisitor codeTableVisitor = new CodeTableVisitor();
        Map<Character, String> codeTable = tree.getRoot().accept(codeTableVisitor);

        // кодирование сообщения
        char[] chars = message.toCharArray();
        StringBuilder result = new StringBuilder();
        for (Character c : chars) {
            result.append(codeTable.get(c));
        }

        return result.toString();
    }

    public String decode(String bits) {
        HuffmanTree.Element root = tree.getRoot();
        DecodingVisitor decodingVisitor = new DecodingVisitor(bits, root);
        return root.accept(decodingVisitor).toString();
    }

    public static HuffmanCodec fromMessage(String message) {
        char[] chars = message.toCharArray();
        // построение частотной таблицы
        HashMap<Character, Integer> frequencyTable = new HashMap<>();
        for (Character ch : chars) {
            frequencyTable.merge(ch, 1, Integer::sum);
        }

        // построение дерева
        Comparator<HuffmanTree> comparator = Comparator.comparing(tree -> tree.getRoot().getFrequency());
        PriorityQ<HuffmanTree> priorityQ = new PriorityQ<>(frequencyTable.size(), comparator);

        for (Map.Entry<Character, Integer> entry : frequencyTable.entrySet()) {
            HuffmanTree.Leaf root = new HuffmanTree.Leaf(entry.getValue(), entry.getKey());
            HuffmanTree tempTree = new HuffmanTree(root);
            priorityQ.insert(tempTree);
        }

        while (priorityQ.size() != 1) {
            HuffmanTree first = priorityQ.remove();
            HuffmanTree second = priorityQ.remove();

            int frequency = first.getRoot().getFrequency() + second.getRoot().getFrequency();
            HuffmanTree.Node newRoot = new HuffmanTree.Node(first.getRoot(), second.getRoot(), frequency);
            HuffmanTree newTree = new HuffmanTree(newRoot);

            priorityQ.insert(newTree);
        }

        HuffmanTree huffmanTree = priorityQ.remove();
        return new HuffmanCodec(huffmanTree);
    }

}
