package com.nazaralwi;

import java.util.Scanner;

public class Helpers {
    public static void printCommandList() {
        System.out.println("Menu Stack");
        System.out.println("1. Insert data");
        System.out.println("2. Cari data");
        System.out.println("3. Cari data terbesar");
        System.out.println("4. Cari data terkecil");
        System.out.println("5. Hapus data");
        System.out.println("6. Hapus seluruh data");
        System.out.println("7. Cari direktori");
        System.out.println("8. Hitung jumlah leaf");
        System.out.println("9. Print secara preorder");
        System.out.println("10. Print secara inorder");
        System.out.println("11. Print secara postorder");
        System.out.println("12. Exit");
    }

    public static void callInsert(Scanner scanner, BinarySearchTree tree) {
        System.out.print("Masukkan jumlah data: ");
        int dataCount = scanner.nextInt();
        for (int i = 0; i < dataCount; i++) {
            System.out.print("Masukkan data: ");
            int data = scanner.nextInt();
            tree.insert(new Node(data));
        }
    }

    public static void callFind(Scanner scanner, BinarySearchTree tree) {
        System.out.print("Data yang dicari: ");
        int data = scanner.nextInt();
        tree.find(data);
    }

    public static void callFindMax(BinarySearchTree tree) {
        System.out.println("Nilai maximum : " + tree.findMax().data);
    }

    public static void callFindMin(BinarySearchTree tree) {
        System.out.println("Nilai minimum : " + tree.findMin().data);
    }

    public static void callRemoveAll(BinarySearchTree tree) {
        tree.removeAll();
    }

    public static void callRemove(Scanner scanner, BinarySearchTree tree) {
        System.out.print("Masukkan data yang dihapus: ");
        int data = scanner.nextInt();
        tree.remove(data);
    }

    public static void callFindDirectory(Scanner scanner, BinarySearchTree tree) {
        System.out.print("Masukkan data: ");
        int data = scanner.nextInt();
        tree.findDirectory(data);
    }

    public static void callGetLeafCount(BinarySearchTree tree) {
        System.out.println("Jumlah leaf: " + tree.getLeafCount());
    }

    public static void callPrintPreorder(BinarySearchTree tree) {
        System.out.println("Urutan secara Preorder: ");
        tree.printPreorder();
    }

    public static void callPrintInorder(BinarySearchTree tree) {
        System.out.println("Urutan secara Inorder: ");
        tree.printInorder();
    }

    public static void callPrintPostorder(BinarySearchTree tree) {
        System.out.println("Urutan secara Postorder: ");
        tree.printPostorder();
    }
}
