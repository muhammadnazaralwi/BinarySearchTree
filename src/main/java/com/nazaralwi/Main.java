package com.nazaralwi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserting the data");
        for (int i = 0; i < 5; i++) {
            System.out.print("Input data: ");
            int input = scanner.nextInt();

            Node data = new Node(input);
            tree.insert(data);
        }

        System.out.println("Find data with path");
        System.out.print("Input data: ");
        int data = scanner.nextInt();
        tree.findDirectory(data);

        System.out.println();

        tree.findMin();
        tree.findMax();
    }
}
