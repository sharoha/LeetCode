package codes.june_challenge.day1;

import codes.fastio_java.InputReader;
import codes.fastio_java.OutputWriter;

public class InvertBinaryTree {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
    }

    /***
     *
     * @param root Root of the binary tree
     * @return root of the inverted binary tree
     * @description The method starts from top and swaps current node child as it goes deep into the tree
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root; // if root is null do nothing
        invertCurrentNode(root); // swap root left and right child
        invertTree(root.left); // call for current node left
        invertTree(root.right); // call for current node right
        return root; // return current node
    }

    private void invertCurrentNode(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    static class TreeNode {
        int val;
        TreeNode left, right;
    }
}
