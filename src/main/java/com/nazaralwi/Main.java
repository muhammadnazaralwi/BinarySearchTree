package com.nazaralwi;

import java.util.Scanner;

public class Main extends Helpers {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        Scanner charScanner = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        int input;
        char isContinue;

        do {
            printCommandList();

            System.out.print("Pilih operasi (1-12): ");
            input = scanner.nextInt();

            System.out.println();
            switch (input) {
                case 1:
                    callInsert(scanner, tree);
                    break;
                case 2:
                    callFind(scanner, tree);
                    break;
                case 3:
                    callFindMax(tree);
                    break;
                case 4:
                    callFindMin(tree);
                    break;
                case 5:
                    callRemove(scanner, tree);
                    break;
                case 6:
                    callRemoveAll(tree);
                    break;
                case 7:
                    callFindDirectory(scanner, tree);
                    break;
                case 8:
                    callGetLeafCount(tree);
                    break;
                case 9:
                    callPrintPreorder(tree);
                    break;
                case 10:
                    callPrintInorder(tree);
                    break;
                case 11:
                    callPrintPostorder(tree);
                    break;
                default:
                    System.out.println("Input tidak valid");
                    break;
            }

            System.out.print("\nLanjut? (y/n): ");
            isContinue = charScanner.next().charAt(0);
            System.out.println();
        } while (input != 12 && (isContinue == 'y' || isContinue == 'Y'));
    }
}
