package com.darthsat.binarysearchtree;

class Node {
    private Node left;
    private Node right;
    private int value;
    private int balanceFactor;

    Node(int value) {
        this.value = value;
        right = null;
        left = null;
        calculateBalanceFactor();
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

    public boolean hasLeft() {
        return left != null;
    }

    public boolean hasRight() {
        return right != null;
    }

    public boolean hasChildren() {
        return hasLeft() || hasRight();
    }

    public int getBalanceFactor() {
        return balanceFactor;
    }

    public int height(Node current) {
        if (current == null) {
            return 0;
        }

        int lheight = current.getLeft() != null ? height(current.getLeft()) : -1;

        int rheight = current.getRight() != null ? height(current.getRight()) : -1;

        return lheight > rheight ? lheight + 1 : rheight + 1;
    }

    public void calculateBalanceFactor() {
        balanceFactor = height(right) - height(left);
    }

    public void rebalance() {

        if (!hasChildren()) {
            return;
        }

        if (balanceFactor == -2 && hasLeft() && left.getBalanceFactor() == -1) {
            rotateRight(left);
        }

        if (balanceFactor == -2 && hasLeft() && left.getBalanceFactor() == 1) {
            rotateLeftRight(left);
        }


        if (balanceFactor == 2 && hasRight() && getRight().getBalanceFactor() == 1) {
            rotateLeft(right);
        }

        if (balanceFactor == 2 && hasRight() && getRight().getBalanceFactor() == -1) {
            rotateRightLeft(right);
        }
    }

    private void rotateLeft(Node n2) {
        if (n2.getRight() == null) {
            return;
        }
        Node n1 = n2.getRight();
        n2.setRight(n1.getLeft());
        n1.setLeft(n2);
        if (n2 == left) {
            left = n1;
        } else {
            right = n1;
        }
    }

    private void rotateRight(Node n1) {
        if (n1.getLeft() == null) {
            return;
        }
        Node n2 = n1.getLeft();
        n1.setLeft(n2.getRight());
        n2.setRight(n1);
        if (n1 == left) {
            left = n2;
        } else {
            right = n2;
        }
    }

    private void rotateRightLeft(Node n3) {
        n3.rotateRight(n3.getRight());
        rotateLeft(n3);
    }

    private void rotateLeftRight(Node n1) {
        n1.rotateLeft(n1.getLeft());
        rotateRight(n1);
    }
}

