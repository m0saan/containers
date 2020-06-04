package com.moboustt;

public class AVLTree {
    private AVLNode root;

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

        if (isLeftHeavy(root)) System.out.println(root.value + " is left heavy");
        else if (isRightHeavy(root)) System.out.println(root.value + " is right heavy");

        return root;
    }

    private boolean isLeftHeavy(AVLNode root){
        return treeHeight(root.leftChild) - treeHeight(root.rightChild) > 1;
    }

    private boolean isRightHeavy(AVLNode root){
        return treeHeight(root.leftChild) - treeHeight(root.rightChild) < -1;
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
            return "AVLNode{" +
                    "value=" + value +
                    '}';
        }
    }

}
