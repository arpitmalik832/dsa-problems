package com.dsa.problems.trees;

/**
Question 4: Valid BST

Consider:

      5
     / \
    1   7
       / \
      4   8

This is not a valid BST because 4 is in the right subtree of 5, even though it's less than 5.

Question

A naive approach checks only:

node.left < node < node.right

for every node.

Why can that approach fail?
What information would you pass recursively down the tree instead?
 */

public class ValidBST {

    static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public TreeNode(int value) {
            this(value, null, null);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(1), new TreeNode(7, new TreeNode(4), new TreeNode(8)));

        int leftBound = Integer.MIN_VALUE;
        int rightBound = Integer.MAX_VALUE;
        boolean isValid = solve(root, leftBound, rightBound);
        System.out.println(isValid);
    }   
    
    private static boolean solve(TreeNode root, int leftBound, int rightBound) {
        if (root.value <= leftBound) return false;
        if (root.value >= rightBound) return false;
        
        if (root.left == null && root.right == null) {
            return true;
        }


        if (root.left != null && root.right != null) {
            return solve(root.left, leftBound, root.value) && solve(root.right, root.value, rightBound);
        } else if (root.left != null) {
            return solve(root.left, leftBound, root.value);
        } else {
            return solve(root.right, root.value, rightBound);
        }
    }
}
