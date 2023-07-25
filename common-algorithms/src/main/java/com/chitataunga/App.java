package com.chitataunga;

import com.chitataunga.algorithms.greedy.HuffmanCoding;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Hello World!");
        TestHuffmanCoding();
    }
    
    static void TestHuffmanCoding() {
        char[] symbols = { 'a', 'd', 'e', 'f' };
        int[] frequencies = { 30, 40, 60, 80 };
        var root = HuffmanCoding.generate(symbols, frequencies);
        HuffmanCoding.printTree(root);
    }
}
