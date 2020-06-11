package com.moboustt;

public class AVLTree {
    private AVLNode root;
    private int size = 0;

    // insert(int value) -> void
    public void insert(int value) {
        root = insert(root, value);
    }


    private AVLNode insert(AVLNode root, int value) {
        if (root == null)
            return new AVLNode(value);

        if (value > root.value) root.rightChild = insert(root.rightChild, value);
        else root.leftChild = insert(root.leftChild, value);

        root.height = 1 + Math.max(treeHeight(root.leftChild), treeHeight(root.rightChild));

        var balanceFactor = getBalanceFactor(root);

        root = balance(root);
        size++;

        return root;
    }

    public boolean isBalanced(){
        return isBalance(root);
    }

    public boolean isPerfect(){
        return Math.pow(2, treeHeight(root) + 1) - 1 == size;
    }

    private boolean isBalance(AVLNode root){
        var left = treeHeight(root.leftChild);
        var right = treeHeight(root.rightChild);

        var height = left - right;
        return height <= 1 && height >= -1;
    }

    private AVLNode balance(AVLNode root) {
        if (isLeftHeavy(root)) {
            if (getBalanceFactor(root.leftChild) < 0)
                root.leftChild = rotateLeft(root.leftChild);
            return rotateRight(root);
        }
        else if (isRightHeavy(root)) {
            if (getBalanceFactor(root.rightChild) > 0)
                root.rightChild = rotateRight(root.rightChild);
            return rotateLeft(root);
        }
        return root;
    }

    private AVLNode rotateLeft(AVLNode root){
        var newRoot = root.rightChild;
        root.rightChild = newRoot.leftChild;
        newRoot.leftChild = root;

        root.height = 1 + Math.max(treeHeight(newRoot.leftChild), treeHeight(newRoot.rightChild));
        root.height = 1 + Math.max(treeHeight(root.leftChild), treeHeight(root.rightChild));

        return newRoot;
    }

    private AVLNode rotateRight(AVLNode root){
        var newRoot = root.rightChild;
        root.leftChild = newRoot.rightChild;
        newRoot.rightChild = root;

        root.height = 1 + Math.max(treeHeight(root.leftChild), treeHeight(root.rightChild));
        root.height = 1 + Math.max(treeHeight(newRoot.leftChild), treeHeight(newRoot.rightChild));

        return newRoot;
    }

    private boolean isLeftHeavy(AVLNode root){
        return getBalanceFactor(root) > 1;
    }

    private boolean isRightHeavy(AVLNode root){
        return getBalanceFactor(root) < -1;
    }

    private int getBalanceFactor(AVLNode root){
        return treeHeight(root.leftChild) - treeHeight(root.rightChild);
    }

    private int treeHeight(AVLNode root) {
        if (root == null)
            return -1;

        if (isLeaf(root))
            return 0;
        return 1 + Math.max(treeHeight(root.leftChild), treeHeight(root.rightChild));
    }

    private boolean isLeaf(AVLNode root) {
        return root.rightChild == null && root.leftChild == null;
    }

    private static class AVLNode {
        private int height;
        private int value;
        private AVLNode leftChild;
        private AVLNode rightChild;

        public AVLNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "value=" + value;
        }
    }

}
