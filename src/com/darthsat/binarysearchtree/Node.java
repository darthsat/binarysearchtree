package com.darthsat.binarysearchtree;

class Node {
    private Node left;
    private Node right;
    private int value;
    private int level;

    Node(int value) {
        this.value = value;
        this.level = 0;
        right = null;
        left = null;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isRoot() {
        return getLevel() == 0;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

