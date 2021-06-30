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
                    System.out.println("Duplicate data not allowed");
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

    void find(int data) {
        Node temp = root;
        boolean checked = false;
        while (temp != null) {
            if (data < temp.data) {
                temp = temp.left;
            } else if (data > temp.data) {
                temp = temp.right;
            } else if (data == temp.data) {
                checked = true;
                break;
            }
        }
        if (checked) {
            System.out.println(data + " found!");
        } else {
            System.out.println("Data not found!");
        }
    }

    Node findMax() {
        Node temp = root;
        if (isEmpty()) {
            return null;
        } else {
            while (temp.right != null) {
                temp = temp.right;
            }
            return temp;
        }
    }

    Node findMin() {
        Node temp = root;
        if (isEmpty()) {
            return null;
        } else {
            while (temp.left != null) {
                temp = temp.left;
            }
            return temp;
        }
    }

    private boolean checking(int input) {
        Node temp = root;
        while (temp != null) {
            if (input < temp.data) {
                temp = temp.left;
            } else if (input > temp.data) {
                temp = temp.right;
            } else {
                return true;
            }
        }
        return false;
    }

    void removeAll() {
        if (isEmpty()) {
            System.out.println("Tree is empty!");
        } else {
            root = null;
            System.out.println("Delete all data succeed");
        }
    }

    private Node remove(int input, Node temp) {
        if (temp == null) {
            return null;
        }

        if (input == temp.data) {
            if (temp.left == null && temp.right == null) {
                return null;
            }

            if (temp.left == null) {
                return temp.right;
            }

            if (temp.right == null) {
                return temp.left;
            }

            temp.data = temp.right.data;
            temp.right = remove(temp.data, temp.right);
        } else if (input < temp.data) {
            temp.left = remove(input, temp.left);
        } else {
            temp.right = remove(input, temp.right);
        }

        return temp;
    }

    public void remove(int input) {
        root = remove(input, root);
        System.out.println("Delete data " + input + " succeed");
    }

    void findDirectory(int input) {
        if (isEmpty()) {
            System.out.println("Tree is empty!");
        } else {
            if (this.checking(input)) {
                Node temp = root;
                while (temp != null) {
                    if (input > temp.data) {
                        System.out.print(temp.data + ", ");
                        temp = temp.right;
                    } else if (input < temp.data) {
                        System.out.print(temp.data + ", ");
                        temp = temp.left;
                    } else {
                        System.out.println(input);
                        break;
                    }
                }
            } else {
                System.out.println("There is no data!");
            }
        }
    }

    public  int getLeafCount() {
        return this.getLeafCountHelper(root);
    }

    private int getLeafCountHelper(Node data) {
        if (data == null) {
            return 0;
        } else if (data.left == null && data.right == null) {
            return 1;
        } else {
            return this.getLeafCountHelper(data.left) + this.getLeafCountHelper(data.right);
        }
    }

    void printPreorder(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.data + " ");

        printPreorder(node.left);

        printPreorder(node.right);
    }

    void printPreorder() {
        printPreorder(root);
    }

    void printInorder(Node node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);

        System.out.print(node.data + " ");

        printInorder(node.right);
    }

    void printInorder() {
        printInorder(root);
    }

    void printPostorder(Node node) {
        if (node == null) {
            return;
        }

        printPostorder(node.left);

        printPostorder(node.right);

        System.out.print(node.data + " ");
    }

    void printPostorder() {
        printPostorder(root);
    }
}
