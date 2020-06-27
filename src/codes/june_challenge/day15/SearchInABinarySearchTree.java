package codes.june_challenge.day15;

import codes.fastio_java.InputReader;
import codes.fastio_java.OutputWriter;
import codes.june_challenge.day23.CountCompleteTreeNodes;

public class SearchInABinarySearchTree {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        TreeNode ans = null;
        if (root.val > val) ans = searchBST(root.left, val);
        else ans = searchBST(root.right, val);
        return ans;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
