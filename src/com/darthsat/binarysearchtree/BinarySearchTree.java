package com.darthsat.binarysearchtree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    Node root;

    BinarySearchTree(ArrayList<Integer> nodeValues) {
        for (Integer nodeValue : nodeValues) {
            add(nodeValue);
        }
    }

    private int level(Node node) {
        return node != null ? node.getLevel() : -1;
    }

    public void add(int value) {
        root = addRecursive(root, value);
    }

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.getValue()) {
            current.setLeft(addRecursive(current.getLeft(), value));
            if (level(current.getLeft()) - level(current.getRight()) == 2) {
                if (value < current.getLeft().getValue()) {
                    current = rotateLeft(current);
                } else {
                    current = doubleRotateLeft(current);
                }
            }
        } else if (value > current.getValue()) {
            current.setRight(addRecursive(current.getRight(), value));
            if (level(current.getRight()) - level(current.getLeft()) == 2) {
                if (value > current.getRight().getValue()) {
                    current = rotateRight(current);
                } else {
                    current = doubleRotateRight(current);
                }
            }
        } else {
            current.setLevel(greaterValue(level(current.getLeft()), level(current.getRight())) + 1);
            return current;
        }

        return current;

    }

    private Node rotateLeft(Node n2) {
        Node n1 = n2.getLeft();
        n2.setLeft(n1.getRight());
        n1.setRight(n2);
        n2.setLevel(greaterValue(level(n2), level(n2.getRight())) + 1);
        n1.setLevel(greaterValue(level(n1.getLeft()), level(n2)) + 1);
        return n1;
    }

    private Node rotateRight(Node n1) {
        Node n2 = n1.getRight();
        n1.setRight(n2.getLeft());
        n2.setLeft(n1);
        n1.setLevel(greaterValue(level(n1.getLeft()), level(n1.getRight())) + 1);
        n2.setLevel(greaterValue(level(n2.getRight()), level(n1)) + 1);
        return n2;
    }

    private Node doubleRotateLeft(Node n3) {
        n3.setLeft(rotateRight(n3.getLeft()));
        return rotateLeft(n3);
    }

    private Node doubleRotateRight(Node n1) {
        n1.setRight(rotateLeft(n1.getRight()));
        return rotateRight(n1);
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

    public void traverse() {

        if (root == null) {
            return;
        }

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {

            Node node = nodes.remove();

            System.out.print(" " + node.getValue());

            if (node.getLeft() != null) {
                nodes.add(node.getLeft());
            }

            if (node.getRight() != null) {
                nodes.add(node.getRight());
            }
        }
        System.out.println();
    }
}
