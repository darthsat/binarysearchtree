package com.darthsat.binarysearchtree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinarySearchTreeTest {
    @Test
    public void TreeDoesNotContainDeletedElements() {
        BinarySearchTree bt = new BinarySearchTree(9, 7, 6, 4, 1, 8, 5);

        assertTrue(bt.containsNode(9));
        bt.delete(9);
        assertFalse(bt.containsNode(9));
    }

    @Test
    public void TreeContainsGivenElements() {
        BinarySearchTree bt = new BinarySearchTree(9, 7, 6, 4, 1, 8, 5);

        assertTrue(bt.containsNode(6));
        assertTrue(bt.containsNode(4));

        assertFalse(bt.containsNode(2));
    }
}
