package com.chitataunga.algorithms.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class HuffmanCoding {
    
    static void buildTree(final char[] symbols, 
    final int[] frequencies,
            PriorityQueue<HuffmanCodingNode> refTree) {
        // the next line is fancy but may impact performance and 
        // a simple forloop might be better
        // Stream<HuffmanCodingNode> nodes = 
        // IntStream.range(0, symbols.length).<HuffmanCodingNode>mapToObj(index -> {
        //     return new HuffmanCodingNode(symbols[index],
        //             frequencies[index], null, null);
        //         });
        // refTree.addAll(nodes.toList());
        for (int index = 0; index < frequencies.length; index++) {
            refTree.add(new HuffmanCodingNode(symbols[index],
                    frequencies[index], null, null));
        }

    }
    static void rebuildTree(PriorityQueue<HuffmanCodingNode> refTree) {
        while (refTree.size() > 1) {
            var left = refTree.poll();
            var right = refTree.poll();
            var root = new HuffmanCodingNode('$', left.frequency()
            + right.frequency(), left, right
            );
            refTree.add(root);
        }
        


    }
    public static 
            HuffmanCodingNode generate(char[] symbols, int[] frequencies) {
        PriorityQueue<HuffmanCodingNode> tree = new PriorityQueue<>(symbols.length,
                (left, right) -> left.frequency() - right.frequency());

        // first create tree
        buildTree(symbols, frequencies, tree);
        rebuildTree(tree);
        return tree.poll();

    }

    public static void printTree(HuffmanCodingNode root) {
        printTree(root, "");
    }
    private static void printTree(HuffmanCodingNode root, String binString) {
        if (null == root) {
            return;
        }
        if ((null == root.left() && null != root.right()) 
                && (null == root.right() && null != root.left())) {
            throw new RuntimeException("the tree is not balanced");
        }
        if (root.symbol() != '$') {
            System.out.printf(root.symbol()+ " " + binString + " | ");
        } else {
            printTree(root.left(), binString + "0");
            printTree(root.right(), binString + "1");
        }
    }
}
