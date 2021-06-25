package com.nazaralwi;

public class BinarySearchTree {
    Node root;

    boolean isEmpty() {
        return root == null;
    }

    void insert(Node input) {
        Node temp = root;
        Node parent = null;
        boolean flag = false;
        if (isEmpty()) {
            root = input;
        } else {
            while (temp != null) {
                parent = temp;
                if (input.data < temp.data) {
                    temp = temp.left;
                    flag = true;
                } else if (input.data > temp.data) {
                    temp = temp.right;
                    flag = true;
                } else {
                    System.out.printf("Duplicate data not allowed");
                    break;
                }
            }

            if (flag) {
                if (input.data > parent.data) {
                    parent.right = input;
                } else if (input.data < parent.data) {
                    parent.left = input;
                }
            }
        }
    }
}
