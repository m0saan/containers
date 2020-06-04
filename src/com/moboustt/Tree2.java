package com.moboustt;

public class Tree2 {
    public static class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }
    }
    private Node root;
    private int treeSize = 0;
    private int size = 0;
    private int countLeaves = 0;
    private boolean contains = false;
    private boolean areSibling = false;

    // Insert(int value)
    // O(log n)
    public void insert(int value){
        treeSize += 1;
        var node = new Node(value);
        if (root == null) {
            root = node;
            return;
        }
        var current = root;
        while (true){

            if (value > current.value){
                if (current.rightChild == null) {
                    current.rightChild = node;
                    break;
                }
                current = current.rightChild;
            }
            else{
                if (current.leftChild == null) {
                    current.leftChild = node;
                    break;
                }
                current = current.leftChild;
            }
        }
    }

    // find(int value) -> boolean
    // O (log n)
    public boolean find(int value){
        var current = root;
        while(current != null){
            if (value > current.value) current = current.rightChild;
            else if (value < current.value) current = current.leftChild;
            else return true;
        }
        return false;
    }

    // Count the number of leaves in a binary tree.
    // O(n)
    public int countLeaves(){
        return countLeaves(root);
    }

    private int countLeaves(Node root){
        if (root == null)
            return 0;

        if (isLeaf(root))
            countLeaves += 1;
        countLeaves(root.leftChild);
        countLeaves(root.rightChild);
        return countLeaves;
    }

    // Binary tree size
    // O(1)
    public int sizeOf(){
        return treeSize;
    }

    // Binary tree size
    // O(n)
    public int size(){
        return size(root);
    }

    public int size(Node root){
        if (root == null)
            return 0;

        size += 1;

        size(root.leftChild);
        size(root.rightChild);

        return size;
    }

    // Traverse Pro Order
    public void traversePreOrder(){
        traversePreOrder(root);
    }

    public void traverseInOrder(){
        traverseInOrder(root);
    }

    public void traversePostOrder(){
        traversePostOrder(root);
    }

    public int Height(){
        return treeHeight(root);
    }

    // Find min value in a Binary Search Tree (BST) using iteration
    // O (log n)
    public int findMinValueInBST(){
        if (root == null)
            throw new IllegalStateException();

        var current = root;
        var last = root;
        while (current != null){
            last = current;
            current = current.leftChild;
        }
        return last.value;
    }

    // Check for the existence of a value in a Binary Search Tree (BST) using recursion
    // O(n)
    public boolean contains(int value){
        return contains(root, value);
    }

    private boolean contains(Node root, int value){
        if (root == null)
            return false;

        if (root.value == value)
            contains = true;

        contains(root.leftChild, value);
        contains(root.rightChild, value);

        return contains;
    }

    // Check if there are siblings value in binary search tree
    public boolean areSibling(int first, int second){
        return areSibling(root, first, second);
    }

    private boolean areSibling(Node root, int first, int second){
        if (root == null)
            return false;

        if (root.leftChild != null && root.rightChild != null)
            if (isSibling(root, first, second))
                areSibling = true;

            areSibling(root.leftChild, first, second);
            areSibling(root.rightChild, first, second);

        return areSibling;
    }

    private boolean isSibling(Node root, int first, int second){
        return (root.leftChild.value == first && root.rightChild.value == second)
                || (root.leftChild.value == second && root.rightChild.value == first);
    }

    // Nodes a k distance
    public void nodesAtKDistance(int k){
        nodesAtKDistance(root, k);
    }

    private void nodesAtKDistance(Node root, int k){
        if (root == null)
            return;

        if (k == 0)
            System.out.println(root.value);

        nodesAtKDistance(root.leftChild,  k -1);
        nodesAtKDistance(root.rightChild,  k -1);
    }

    // Swap Tree
    public void swapRoot(){
        var tmp = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = tmp;
    }

    // Validating Binary Search Tree
    public boolean isBST(){
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBST(Node root, int min, int max){
        if (root == null)
            return true;
        if (root.value < min || root.value > max)
            return false;

        return isBST(root.leftChild, min, root.value -1) && isBST(root.rightChild, root.value + 1, max);
    }

    // Find max Value in a Binary Tree (BT)
    // O(n)
    public int max(){
        return findMaxValueInBT(root);
    }

    private int findMaxValueInBT(Node root){
        if (root == null)
            return 0;

        if (root.rightChild == null)
            return root.value;

        return findMaxValueInBT(root.rightChild);
    }

    // Find min Value in a Binary Tree (BT)
    // O(n)
    public int findMinValueInBT(){
        return findMinValueInBT(root);
    }

    public boolean isEqual(Tree2 other){
        if (other == null)
            return false;
        return isEqual(root, other.root);
    }

    public void levelOrderTraversal(){
        var height = treeHeight(root);
        for (int i = 0; i <= height ; i++) {
            nodesAtKDistance(i);
        }
    }

    private boolean isEqual(Node first, Node second){
        if (first == null && second == null)
            return true;

        if (first != null && second != null)
            return first.value == second.value &&
                    isEqual(first.leftChild, second.leftChild) && isEqual(first.rightChild, second.rightChild);
        return false;
    }

    private int findMinValueInBT(Node root){
        if (root == null)
            return -1;

        if (isLeaf(root))
            return root.value;
        var leftMinValue = findMinValueInBT(root.leftChild);
        var rightMinValue = findMinValueInBT(root.rightChild);

        return Math.min(Math.min(leftMinValue, rightMinValue), root.value);
    }

    private int treeHeight(Node root){
        if (root == null)
            return -1;

        if (isLeaf(root))
            return 0;
        return 1 + Math.max(treeHeight(root.leftChild), treeHeight(root.rightChild));
    }

    private void traversePostOrder(Node root){
        if (root == null)
            return;

        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.println(root.value);
    }

    private void traverseInOrder(Node root){
        if (root == null)
            return;

        traverseInOrder(root.leftChild);
        System.out.println(root.value);
        traverseInOrder(root.rightChild);
    }

    private void traversePreOrder(Node root){
        if (root == null)
            return;

        System.out.println(root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    private boolean isLeaf(Node root){
        return root.rightChild == null && root.leftChild == null;
    }
}
