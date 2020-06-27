package codes.june_challenge.day23;

import codes.fastio_java.InputReader;
import codes.fastio_java.OutputWriter;

public class CountCompleteTreeNodes {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
    }

    int count = 0;
    public int countNodes(TreeNode root) {
        count = 0;
        recur(root);
        return count;
    }
    public void recur(TreeNode root) {
        if (root == null) return;
        count++;
        recur(root.left);
        recur(root.right);
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
