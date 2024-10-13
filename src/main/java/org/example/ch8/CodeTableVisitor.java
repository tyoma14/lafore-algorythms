package org.example.ch8;

import java.util.HashMap;
import java.util.Map;

/**
 * Посетитель дерева для построения таблицы кодов
 */
public class CodeTableVisitor implements TreeVisitor<Map<Character, String>> {

    private final Map<Character, String> codeTable;
    private final String characterBits;

    public CodeTableVisitor() {
        this.codeTable = new HashMap<>();
        this.characterBits = "";
    }

    public CodeTableVisitor(Map<Character, String> codeTable, String characterBits) {
        this.codeTable = codeTable;
        this.characterBits = characterBits;
    }

    @Override
    public Map<Character, String> visit(HuffmanTree.Node node) {
        HuffmanTree.Element left = node.getLeft();
        left.accept(new CodeTableVisitor(codeTable, characterBits + "0"));

        HuffmanTree.Element right = node.getRight();
        right.accept(new CodeTableVisitor(codeTable, characterBits + "1"));

        return codeTable;
    }

    @Override
    public Map<Character, String> visit(HuffmanTree.Leaf leaf) {
        codeTable.put(leaf.getCharacter(), characterBits);
        return codeTable;
    }
}
