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
            System.out.printf(data + " found!");
        } else {
            System.out.printf("Data not found!");
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
            System.out.println("Data has been deleted");
        }
    }

    private Node remove(int input, Node temp) {
        if (temp == null) {
            return null;
        } else {
            if (this.checking(input)) {
                if (input < temp.data) {
                    temp.left = remove(input, temp.left);
                } else {
                    if (input > temp.data) {
                        temp.right = remove(input, temp.right);
                    } else {
                        if (temp.left != null && temp.right != null) {
                            temp.data = temp.right.data;
                            this.findMin();
                            temp.right = remove(temp.data, temp.right);
                        } else {
                            temp = (temp.left != null) ? temp.left : temp.right;
                            System.out.println("Data " + input + " has been deleted");
                        }
                    }
                }
            } else {
                return null;
            }
            return temp;
        }
    }

    public void remove(int input) {
        if (this.remove(input, root) == null) {
            System.out.printf("Data " + input + " doesn't exist");
        } else {
            root = remove(input, root);
        }
    }
}
