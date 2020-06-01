package com.moboustt;

public class Tree {
    private Node root;

    public void insert(int value) {
        var node = new Node(value);
        if (root == null)
            root = node;
        else {
            var current = root;
            while (true) {
                if (value > current.value) {
                    if (current.rightChild == null) {
                        current.rightChild = node;
                        break;
                    }
                    current = current.rightChild;
                } else {
                    if (current.leftChild == null) {
                        current.leftChild = node;
                        break;
                    }
                    current = current.leftChild;
                }
            }
        }
    }

    // insert(int value)

    // find(int value) -> boolean
    public boolean find(int value) {
        var current = root;
        while (current != null) {
            if (value > current.value) current = current.rightChild;
            else if (value < current.value) current = current.leftChild;
            else return true;
        }
        return false;
    }

    public void nodesAtKDistance(int k){
        nodesAtKDistance(root, k);
    }

    private void nodesAtKDistance(Node root, int k){
        if (root == null)
            return;

        if (k == 0) {
            System.out.println(root.value);
            return;
        }

        nodesAtKDistance(root.leftChild, k - 1);
        nodesAtKDistance(root.rightChild, k - 1);
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    public int treeHeight() {
        return treeHeight(root);
    }

    public int treeMinimumValue() {
        return treeMinimumValue(root);
    }

    // O(log n)
    // Find the max value in a Binary Search Tree (BST).
    public int BSTMax() {
        if (root == null)
            throw new IllegalStateException();

        var current = root;
        var last = root;
        while (current != null) {
            last = current;
            current = current.rightChild;
        }
        return last.value;
    }

    // O(log n)
    // Find the min value in a Binary Search Tree (BST).
    public int BSTMin() {
        if (root == null)
            throw new IllegalStateException();

        var current = root;
        while (true) {
            if (current.leftChild == null)
                return current.value;
            current = current.leftChild;
        }
    }

    // swap the tree
    public void swapRoot() {
        var temp = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = temp;
    }

    // Validating Binary Search Tree
    public boolean validatingBSTs() {
        return validatingBSTs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean validatingBSTs(Node root, int min, int max) {

        if (root == null)
            return true;
        if (root.value < min || root.value > max)
            return false;
        return validatingBSTs(root.leftChild, Integer.MIN_VALUE, root.value - 1)
                && validatingBSTs(root.rightChild, root.value + 1, max);
    }

    // Equality Checking
    public boolean isEqual(Tree other) {
        return equal(root, other.root);
    }

    private boolean equal(Node first, Node second) {

        if (first == null && second == null)
            return true;

        if (first != null && second != null)
            return first.value == second.value && equal(first.leftChild, second.leftChild)
                    && equal(first.rightChild, second.rightChild);
        return false;
    }

    // O(n)
    private int treeMinimumValue(Node root) {
        if (root == null)
            return -1;

        if (root.leftChild == null && root.rightChild == null)
            return root.value;

        var leftMin = treeMinimumValue(root.leftChild);
        var rightMin = treeMinimumValue(root.rightChild);
        return Math.min(Math.min(leftMin, rightMin), root.value);
    }

    private int treeHeight(Node root) {
        if (root == null)
            return -1;

        if (root.leftChild == null && root.rightChild == null)
            return 0;
        return 1 + Math.max(treeHeight(root.leftChild), treeHeight(root.rightChild));
    }

    private void traversePostOrder(Node root) {
        if (root == null)
            return;
        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.println(root.value);
    }

    private void traverseInOrder(Node root) {
        if (root == null)
            return;
        traverseInOrder(root.leftChild);
        System.out.println(root.value);
        traverseInOrder(root.rightChild);
    }

    private void traversePreOrder(Node root) {
        if (root == null)
            return;
        System.out.println(root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    private static class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }
}
