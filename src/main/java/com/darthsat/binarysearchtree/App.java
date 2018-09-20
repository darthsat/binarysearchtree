package com.darthsat.binarysearchtree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {


        BinarySearchTree bst = new BinarySearchTree(new ArrayList<>(Arrays.asList(2, 1, 3, 4, 6, 7, 8)));

        bst.printTree();
//        Scanner in = new Scanner(System.in);
//        ArrayList<Integer> inputList = new ArrayList<>();
//
//        System.out.println("Type \"quit\" to quit program. \n" +
//                "Enter the number to add or type \"end\" to finish: ");
//        loop:
//        while (true) {
//            String input = in.next();
//            switch (input) {
//                case "end":
//                    break loop;
//                case "quit":
//                    return;
//                default:
//                    try {
//                        int i = Integer.parseInt(input);
//                        inputList.add(i);
//                        System.out.println("Number " + i + " added");
//                    } catch (NumberFormatException e) {
//                        System.out.println("Please, enter the number to add or type \"end\" to finish: ");
//                    }
//                    break;
//            }
//        }
//
//        BinarySearchTree bst = new BinarySearchTree(inputList);
//
//        if (bst.root != null) {
//            System.out.println("Your tree: ");
//            bst.traverse();
//        }
//
//        while (true) {
//            System.out.println("type \"delete\" to delete chosen number from tree  \n " +
//                    "type \"add\" to add number to tree \n " +
//                    "type \"quit\" to quit");
//
//            String input = in.next();
//            switch (input) {
//                case "quit":
//                    return;
//                case "delete":
//                    System.out.println("Enter the number to delete");
//                    input = in.next();
//                    if (input.equals("abort")) {
//                        break;
//                    }
//                    try {
//                        int i = Integer.parseInt(input);
//                        if (!bst.containsNode(i)) {
//                            System.out.println("Number " + i + " not found \n");
//                            break;
//                        }
//                        bst.delete(i);
//                        System.out.println("Number " + i + " deleted \n");
//                    } catch (InputMismatchException e) {
//                        System.out.println("Please, enter the number to delete or type \"abort\" to abort: ");
//                    }
//                    break;
//                case "add":
//                    System.out.println("Enter the number to add");
//                    input = in.next();
//                    if (input.equals("abort")) {
//                        break;
//                    }
//                    try {
//                        int i = Integer.parseInt(input);
//                        if (bst.containsNode(i)) {
//                            System.out.println("Number " + i + " already exists \n");
//                            break;
//                        }
//                        bst.add(i);
//                        System.out.println("Number " + i + " added \n");
//                    } catch (InputMismatchException e) {
//                        System.out.println("Please, enter the number to add or type \"abort\" to abort: ");
//                    }
//                    break;
//            }
//            bst.traverse();
//        }
//    }
}
}