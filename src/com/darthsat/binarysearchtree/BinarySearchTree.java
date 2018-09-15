package com.darthsat.binarysearchtree;

import java.util.ArrayList;
import java.util.LinkedList;

public class BinarySearchTree {
    Node root;

    BinarySearchTree(ArrayList<Integer> nodeValues) {
        for (Integer nodeValue : nodeValues) {
            add(nodeValue);
        }
    }

    public void add(int value) {
        root = addRecursive(root, value);
    }

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            current = new Node(value);
            updateBalanceFactors();
            current.rebalance();
            return current;
        }

        if (value < current.getValue()) {
            current.setLeft(addRecursive(current.getLeft(), value));
        }

        if (value > current.getValue()) {
            current.setRight(addRecursive(current.getRight(), value));
        }
        updateBalanceFactors();
        current.rebalance();
        return current;
    }

    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }

    private boolean containsNodeRecursive(Node current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.getValue()) {
            return true;
        }
        return value < current.getValue()
                ? containsNodeRecursive(current.getLeft(), value)
                : containsNodeRecursive(current.getRight(), value);
    }

    public void updateBalanceFactors() {
        updateBalanceFactorRecursive(root);
    }

    private void updateBalanceFactorRecursive(Node current) {
        if (current == null) {
            return;
        }

        current.calculateBalanceFactor();

        if (current.getLeft() != null) {
            updateBalanceFactorRecursive(current.getLeft());
        }

        if (current.getRight() != null) {
            updateBalanceFactorRecursive(current.getRight());
        }
    }


    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    private Node deleteRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.getValue()) {
            if (current.getLeft() == null && current.getRight() == null) {
                return null;
            }

            if (current.getRight() == null) {
                return current.getLeft();
            }

            if (current.getLeft() == null) {
                return current.getRight();
            }

            int smallestValue = findSmallestValue(current.getRight());
            current.setValue(smallestValue);
            current.setRight(deleteRecursive(current.getRight(), smallestValue));
            return current;

        }
        if (value < current.getValue()) {
            current.setLeft(deleteRecursive(current.getLeft(), value));
            return current;
        }
        current.setRight(deleteRecursive(current.getRight(), value));
        return current;
    }

    private int findSmallestValue(Node root) {
        return root.getLeft() == null ? root.getValue() : findSmallestValue(root.getLeft());
    }

    private int greaterValue(int v1, int v2) {
        return v1 > v2 ? v1 : v2;
    }

    void print(Node root, int space) {
        int count = 10;

        if (root == null)
            return;

        space += count;

        // Process right child first
        print(root.getRight(), space);

        // Print current node after space
        // count
        System.out.format("\n");
        for (int i = count; i < space; i++) {
            System.out.format(" ");
        }
        System.out.format("%d\n", root.getValue());

        print(root.getLeft(), space);
    }

    void printTree() {
        print(root, 0);
    }
}
