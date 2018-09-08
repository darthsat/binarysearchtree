package com.darthsat.binarysearchtree;

public class Main {

    public static void main(String[] args) {

        int values[] = new int[args.length];

        for (int i = 0; i < args.length; i++) {
            int value = Integer.parseInt(args[i]);
            values[i] = value;
        }
        BinarySearchTree bst = new BinarySearchTree(values);
        bst.traverse();
    }
}
